package com.github.psygate.discord.owlbot.events;

import com.github.psygate.discord.owlbot.commands.parsing.CommandParser;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.object.entity.Message;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandEvent extends Event {
    private final Message message;
    private final CommandParser commandParser;

    public CommandEvent(DiscordClient client, Message message) {
        this(client, message, message.getContent().orElse(""));
    }

    public CommandEvent(DiscordClient client, Message message, String value) {
        super(client);
        this.message = message;
        commandParser = new CommandParser(value);
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CommandEvent{" +
                "message=" + message +
                '}';
    }
}
