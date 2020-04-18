package com.github.psygate.discord.owlbot;

import com.github.psygate.discord.owlbot.commands.CommandManager;
import com.github.psygate.discord.owlbot.events.CommandEvent;
import com.github.psygate.discord.owlbot.events.CommandPermissionDeniedEvent;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomlj.TomlTable;

import java.io.IOException;

public class Bot implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Bot.class);
    private final TomlTable config;
    private final CommandManager commandManager;

    public Bot(TomlTable config, CommandManager commandManager) {
        this.config = config;
        this.commandManager = commandManager;
    }


    public void run() {
        final DiscordClient client = new DiscordClientBuilder(config.getString("secrets.token")).build();

        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(ready -> LOGGER.info("Logged in as " + ready.getSelf().getUsername()));

        client.getEventDispatcher()
                .on(MessageCreateEvent.class)
                .subscribe(this::parseMessage)
        ;

        client.getEventDispatcher()
                .on(CommandEvent.class)
                .subscribe(commandManager::process)
        ;

        client.getEventDispatcher()
                .on(CommandPermissionDeniedEvent.class)
                .subscribe(ev -> ev.getBotCommandEvent().getMessage().getChannel().subscribe(mc -> mc.createMessage("Not allowed.")));

        var r = new Runnable() {
            @Override
            public void run() {
                LOGGER.debug("Client bootstrapped. Running event thread.");
                client.login().block();
            }
        };

        var t = new Thread(r);
        t.setDaemon(true);
        t.setName("Discord-Event-Processing-Thread");
        t.start();

        try {
            System.in.read();
        } catch (IOException e) {

        }

        t.interrupt();
        if (client.isConnected()) {
            client.logout().block();
        }
    }

    private void parseMessage(MessageCreateEvent mce) {
        LOGGER.debug("Message: " + mce);
        if (isACommand(mce)) {
            mce.getClient().getEventDispatcher().publish(new CommandEvent(
                    mce.getClient(),
                    mce.getMessage()
            ));
        } else {
            LOGGER.warn("Unmanaged message: " + mce);
        }
    }

    private boolean isACommand(MessageCreateEvent mce) {
        return (mce.getMessage().getContent().map(c -> c.startsWith(config.getString("commands.settings.command_prefix"))).orElse(false));
    }
}
