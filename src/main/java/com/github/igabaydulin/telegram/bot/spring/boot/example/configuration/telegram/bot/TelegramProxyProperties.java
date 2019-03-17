package com.github.igabaydulin.telegram.bot.spring.boot.example.configuration.telegram.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import javax.annotation.PostConstruct;

@Slf4j
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "telegram.bot.proxy")
public class TelegramProxyProperties {

    private boolean enabled = false;
    private DefaultBotOptions.ProxyType type;
    private String host;
    private int port;

    @PostConstruct
    public void setUp() throws JsonProcessingException {
        if (enabled) {
            log.debug("Telegram Proxy is enabled");
            ObjectMapper objectMapper = new ObjectMapper();
            log.debug("Telegram Proxy properties: {}", objectMapper.writeValueAsString(this));
        } else {
            log.debug("Telegram Proxy is disabled");
        }
    }
}
