package com.github.igabaydulin.telegram.bot.spring.boot.example.configuration.telegram.bot;

import com.github.igabaydulin.telegram.bot.spring.boot.example.service.telegram.bot.AlertsTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.updatesreceivers.ExponentialBackOff;

@Slf4j
@Configuration
public class TelegramBotConfiguration {

    private DefaultBotOptions defaultBotOptions() {
        DefaultBotOptions defaultBotOptions = ApiContext.getInstance(DefaultBotOptions.class);
        defaultBotOptions.setExponentialBackOff(telegramExponentialBackOff());

        return defaultBotOptions;
    }

    private ExponentialBackOff telegramExponentialBackOff() {
        return new ExponentialBackOff.Builder().build();
    }

    @Bean
    @ConditionalOnProperty(name = "telegram.bot.proxy.enabled", havingValue = "false", matchIfMissing = true)
    public TelegramLongPollingBot defaultAlertsTelegramBot(TelegramBotCredentialsProperties credentials) {
        log.debug("defaultAlertsTelegramBot bean creation");
        AlertsTelegramBot alertsTelegramBot = new AlertsTelegramBot(credentials, defaultBotOptions());
        log.debug("defaultAlertsTelegramBot is created");
        return alertsTelegramBot;
    }

    @Bean
    @ConditionalOnProperty(name = "telegram.bot.proxy.enabled", havingValue = "true")
    public TelegramLongPollingBot proxyAlertsTelegramBot(TelegramBotCredentialsProperties credentials, TelegramProxyProperties proxyProperties) {
        log.debug("proxyAlertsTelegramBot bean creation");
        DefaultBotOptions defaultBotOptions = defaultBotOptions();
        defaultBotOptions.setProxyType(proxyProperties.getType());
        defaultBotOptions.setProxyHost(proxyProperties.getHost());
        defaultBotOptions.setProxyPort(proxyProperties.getPort());
        log.debug("proxyAlertsTelegramBot is created");

        return new AlertsTelegramBot(credentials, defaultBotOptions);
    }
}
