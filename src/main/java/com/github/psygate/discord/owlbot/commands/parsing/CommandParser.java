package com.github.psygate.discord.owlbot.commands.parsing;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommandParser {
    private final String command;
    private final List<String> arguments;

    public CommandParser(String value) {
        if (value == null || value.trim().strip().isEmpty()) {
            throw new IllegalArgumentException("String is empty or null. (" + value + ")");
        } else {
            var charStream = CharStreams.fromString(value);
            var lexer = new OwlBotCommandGrammarLexer(charStream);
            var tokenStream = new BufferedTokenStream(lexer);
            var parser = new OwlBotCommandGrammarParser(tokenStream);
            var listener = new ParseListener();
//        var listener = new OwlBotCommandGrammarBaseVisitor<List<String>>();
            var ctx = parser.parseCommand();

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, ctx);

            command = Objects.requireNonNull(listener.command);
            arguments = Objects.requireNonNull(listener.arguments);
        }
    }

    public String getCommand() {
        return command;
    }

    public List<String> getArguments() {
        return arguments;
    }

    private static class ParseListener extends OwlBotCommandGrammarBaseListener {
        private String command;
        private final List<String> arguments = new ArrayList<>();

        @Override
        public void exitCommandName(OwlBotCommandGrammarParser.CommandNameContext ctx) {
            command = ctx.getText();
        }

        @Override
        public void exitArgument(OwlBotCommandGrammarParser.ArgumentContext ctx) {
            if (ctx.nonWhiteSpace() != null) {
                arguments.add(ctx.nonWhiteSpace().getText());
            } else if (ctx.string() != null) {
                String raw;

                if (ctx.string().DOUBLE_QUOTE_STRING() != null) {
                    raw = ctx.string().DOUBLE_QUOTE_STRING().getText();
                } else if (ctx.string().SINGLE_QUOTE_STRING() != null) {
                    raw = ctx.string().SINGLE_QUOTE_STRING().getText();
                } else {
                    throw new IllegalStateException();
                }

                if (raw.equals("\"\"") || raw.equals("\'\'")) {
                    arguments.add("");
                } else {
                    String text = raw.substring(1, raw.length() - 1).replaceAll("\\\\(.)", "$1");
                    arguments.add(text);
                }
            } else {
                throw new IllegalStateException();
            }
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public List<String> getArguments() {
            return arguments;
        }
    }
}
