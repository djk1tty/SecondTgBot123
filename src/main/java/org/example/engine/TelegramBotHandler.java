package org.example.engine;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotHandler extends TelegramLongPollingBot {
    private String botUsername = "javaJokesTest208bot";
    private String botToken = "6724036344:AAFDn9Ql7e8zDxIfb9Kq3xAVZGOxe58eZjE";

    private TelegramBotLogic telegramBotLogic = new TelegramBotLogic();

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage messageToUser = new SendMessage();

        long chatId = 0;
        String textFromUser = "";

        if (update.hasMessage()) {
            chatId = update.getMessage().getChatId();
            textFromUser = update.getMessage().getText();

            telegramBotLogic.processTextMessageFromUser(textFromUser, messageToUser);

        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            textFromUser = update.getCallbackQuery().getData();

            telegramBotLogic.processInlineButtonClickFromUser(textFromUser, messageToUser);

        }
        messageToUser.setChatId(chatId);

        try {
            execute(messageToUser);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
