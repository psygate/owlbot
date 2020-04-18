package com.github.psygate.discord.owlbot.commands;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class RawCommand {
    private final String executorClassName;
    private final String commandString;
    private final Class<CommandExecutor> executorClass;

    public RawCommand(final String commandString, final String executorClassName) {
        try {
            this.commandString = Objects.requireNonNull(commandString);
            this.executorClassName = Objects.requireNonNull(executorClassName);
            this.executorClass = (Class<CommandExecutor>) Class.forName(Objects.requireNonNull(executorClassName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getExecutorClassName() {
        return executorClassName;
    }

    public String getCommandString() {
        return commandString;
    }

    @Override
    public String toString() {
        return "Command{" +
                "executorClass='" + executorClassName + '\'' +
                '}';
    }
}
