package com.github.psygate.discord.owlbot;

import com.github.psygate.discord.owlbot.commands.RawCommand;
import com.github.psygate.discord.owlbot.commands.CommandManager;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;
import org.tomlj.TomlTable;

import java.io.*;


public class Main {
    private static TomlParseResult createEffectiveConfiguration() throws IOException {
        var composition = new ByteArrayOutputStream();
        try (
                FileInputStream in = new FileInputStream("config.toml");
        ) {
            in.transferTo(composition);
        }

        composition.write('\n');

        try (
                FileInputStream in = new FileInputStream("secrets.toml");
        ) {
            in.transferTo(composition);
        }

        return Toml.parse(new ByteArrayInputStream(composition.toByteArray()));
    }

    public static void main(String[] args) throws Exception {
        var config = createEffectiveConfiguration();
        var commandManager = new CommandManager();
        initCommands(commandManager, config.getTableOrEmpty("commands.bindings"));
        var bot = new Bot(config, commandManager);
        bot.run();
    }

    private static void initCommands(CommandManager commandManager, TomlTable commandConfig) {
        commandConfig.keySet().stream()
                .map(commandConfig::getTable)
                .map(Main::asCommand)
                .forEachOrdered(commandManager::addCommand);
    }

    private static RawCommand asCommand(TomlTable tomlTable) {
        return new RawCommand(
                tomlTable.getString("alias"),
                tomlTable.getString("executor")
        );
    }
}
