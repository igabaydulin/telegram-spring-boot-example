package com.github.igabaydulin.telegram.bot.spring.boot.example.service.telegram.bot;

import com.github.igabaydulin.telegram.bot.spring.boot.example.configuration.telegram.bot.TelegramBotCredentialsProperties;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class AlertsTelegramBot extends TelegramLongPollingBot {

    private final TelegramBotCredentialsProperties credentials;

    public AlertsTelegramBot(TelegramBotCredentialsProperties credentials, DefaultBotOptions defaultBotOptions) {
        super(defaultBotOptions);
        this.credentials = credentials;
    }

    @Override
    public String getBotToken() {
        return credentials.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            SendMessage message = new SendMessage(update.getMessage().getChatId(), "ping");
            try {
                this.execute(message);
            } catch (TelegramApiException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return credentials.getBotUsername();
    }
}
