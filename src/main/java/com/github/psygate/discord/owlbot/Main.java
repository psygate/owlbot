package com.github.psygate.discord.owlbot;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import io.vavr.control.Either;
import org.tomlj.Toml;
import org.tomlj.TomlParseError;
import org.tomlj.TomlParseResult;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static io.vavr.API.*;        // $, Case, Match
import static io.vavr.Predicates.*; // instanceOf

public class Main {
    private static TomlParseResult loadSettings(String confFile) {
        try {
            var toml = Toml.parse(Paths.get(confFile));

            if (toml.hasErrors()) {
                throw new RuntimeException(toml.errors().toString());
            } else {
                return toml;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static TomlParseResult loadSecrets(TomlParseResult conf) {
        try {
            var toml = Toml.parse(Paths.get(conf.getString("main.secrets_file")));

            if (toml.hasErrors()) {
                throw new RuntimeException(toml.errors().toString());
            } else {
                return toml;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initBot(TomlParseResult conf, TomlParseResult secrets) {
        System.out.println("Using token: " + secrets.getString("token"));
        var client = new DiscordClientBuilder(secrets.getString("token"))
                .build();

        client.getEventDispatcher()
                .on(ReadyEvent.class)
                .subscribe(ready -> System.out.println("Logged in as " + ready.getSelf().getUsername()));

        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filter(msg -> msg.getContent().map("!ping"::equals).orElse(false))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("Pong!"))
                .subscribe();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                client.logout();
            }
        });
        client.login().block();
    }

    public static void main(String[] args) {
        //TODO proper exception
        var settings = loadSettings("config.toml");
        var secrets = loadSecrets(settings);

        initBot(settings, secrets);
    }
}
/*

//object Main {
//  def loadSettings() = {
//    val toml = Toml.parse(Paths.get("config.toml"))
//    if (toml.hasErrors) {
//      Left(toml.errors())
//    } else {
//      Right(toml)
//    }
//  }
//
//  def loadSecrets(conf: TomlParseResult) = {
//    val propFileKey = "main.secrets_file"
//    val toml = Toml.parse(Paths.get(conf.getString(propFileKey)))
//    if (toml.hasErrors) {
//      Left(toml.errors())
//    } else {
//      Right(toml)
//    }
//  }
//
//  def initBot(conf: TomlParseResult, secrets: TomlParseResult) = {
//    val client = new DiscordClientBuilder(secrets.getString("token")).build
//
//    client.getEventDispatcher.on(classOf[ReadyEvent]).subscribe((ready: ReadyEvent) => System.out.println("Logged in as " + ready.getSelf.getUsername))
//
//    client.getEventDispatcher.on(classOf[MessageCreateEvent])
//      .map(_.getMessage)
//      .filter((msg: Message) => msg.getContent.map("!ping".equals).orElse(false))
//      .flatMap(_.getChannel)
//      .flatMap((channel: MessageChannel) => channel.createMessage("Pong!"))
//      .subscribe
//
//    client.login().block();
//
//    /*
//    final DiscordClient client = new DiscordClientBuilder("token").build();
//
//client.getEventDispatcher().on(ReadyEvent.class)
//        .subscribe(ready -> System.out.println("Logged in as " + ready.getSelf().getUsername()));
//
//client.getEventDispatcher().on(MessageCreateEvent.class)
//        .map(MessageCreateEvent::getMessage)
//        .filter(msg -> msg.getContent().map("!ping"::equals).orElse(false))
//        .flatMap(Message::getChannel)
//        .flatMap(channel -> channel.createMessage("Pong!"))
//        .subscribe();
//
//client.login().block();
//
//  }
//
//  def main(args: Array[String]): Unit = {
//    loadSettings() match {
//      case Left(errors) => println(errors)
//      case Right(conf) => {
//        loadSecrets(conf) match {
//          case Left(errors) => println(errors)
//          case Right(secrets) => initBot(conf, secrets)
//        }
//      }
//    }
//  }
//
*/