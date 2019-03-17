package com.github.igabaydulin.telegram.bot.spring.boot.example;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        new SpringApplicationBuilder(App.class).bannerMode(Banner.Mode.OFF).run(args);
    }
}
