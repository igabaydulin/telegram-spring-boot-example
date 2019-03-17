package com.github.igabaydulin.telegram.bot.spring.boot.example.configuration.telegram.bot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "telegram.bot.credentials")
public class TelegramBotCredentialsProperties {

    private String token;
    private String botUsername;
}
