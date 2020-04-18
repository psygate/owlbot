package com.github.psygate.discord.owlbot.events;

import discord4j.core.event.domain.Event;

import java.util.Objects;

public class CommandPermissionDeniedEvent extends Event {
    private final CommandEvent botCommandEvent;

    public CommandPermissionDeniedEvent(CommandEvent botCommandEvent) {
        super(botCommandEvent.getClient());
        this.botCommandEvent = Objects.requireNonNull(botCommandEvent);
    }

    public CommandEvent getBotCommandEvent() {
        return botCommandEvent;
    }

    @Override
    public String toString() {
        return "CommandPermissionDeniedEvent{" +
                "botCommandEvent=" + botCommandEvent +
                '}';
    }
}
