package com.github.psygate.discord.owlbot.commands.parsing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    @Test
    public void testCommandParsing1() {
        assertThrows(IllegalArgumentException.class, () -> {
            CommandParser parser = new CommandParser("");
        });
    }

    @Test
    public void testCommandParsing2() {
        String commandString = "test";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(Collections.emptyList(), p.getArguments());
    }

    @Test
    public void testCommandParsing3() {
        String commandString = "test a";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("a"), p.getArguments());
    }

    @Test
    public void testCommandParsing4() {
        String commandString = "test  a";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("a"), p.getArguments());
    }

    @Test
    public void testCommandParsing5() {
        String commandString = "test a b";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("a", "b"), p.getArguments());
    }

    @Test
    public void testCommandParsing6() {
        String commandString = "test a b  ";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("a", "b"), p.getArguments());
    }

    @Test
    public void testCommandParsing7() {
        String commandString = "test a b \"test \"";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("a", "b", "test "), p.getArguments());
    }

    @Test
    public void testCommandParsing8() {
        String commandString = "test a b \"  \t \\\"\"";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("a", "b", "  \t \""), p.getArguments());
    }

    @Test
    public void testCommandParsing9() {
        String commandString = "test \"\" ''";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("", ""), p.getArguments());
    }

    @Test
    public void testCommandParsing10() {
        String commandString = "test \"''\" '\"\"'";
        CommandParser p = new CommandParser(commandString);
        assertEquals("test", p.getCommand());
        assertEquals(List.of("''", "\"\""), p.getArguments());
    }
}
