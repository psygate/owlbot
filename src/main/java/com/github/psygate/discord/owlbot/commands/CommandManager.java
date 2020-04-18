package com.github.psygate.discord.owlbot.commands;

import com.github.psygate.discord.owlbot.Emojis;
import com.github.psygate.discord.owlbot.events.CommandEvent;
import com.github.psygate.discord.owlbot.events.CommandPermissionDeniedEvent;
import discord4j.core.object.entity.GuildEmoji;
import discord4j.core.object.reaction.ReactionEmoji;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CommandManager {
    private final static Logger LOGGER = LogManager.getLogger(CommandManager.class);
    private Map<String, RawCommand> commands = new HashMap<>();

    public void addCommand(RawCommand command) {
        if (commands.containsKey(command.getCommandString())) {
            throw new RuntimeException("Duplicate command: " + command.getCommandString() + " (" + command + ")");
        }

        commands.put(command.getCommandString(), command);
    }

    public RawCommand parseCommand(String message) {
        List<String> strings = new ArrayList<>();
        String content = message.strip();
        String command = content.strip();

        throw new UnsupportedOperationException();
    }

    public void process(CommandEvent commandEvent) {
        LOGGER.debug("Command event: " + commandEvent);
        commandEvent.getMessage().getChannel()
                .flatMap(channel -> channel.createMessage("Permission denied."))
                .subscribe()
        ;

        commandEvent.getMessage()
                .addReaction(ReactionEmoji.unicode(Emojis.NO_ENTRY_SIGN.unicodeString))
                .subscribe()
        ;
    }
}
