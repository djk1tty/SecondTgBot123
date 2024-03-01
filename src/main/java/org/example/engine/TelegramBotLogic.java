package org.example.engine;

import org.example.buttons.InlineButtonsStorage;
import org.example.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class TelegramBotLogic {

    public void processTextMessageFromUser(String textFromUser, SendMessage messageToUser) {
        String textToUser = "";

        if (textFromUser.equals("/start")) {
            textToUser = "Привет, я твой бот помощник. Выбери действие по кнопке";

            messageToUser.setReplyMarkup(InlineKeyboardsStorage.getStartMessageKeyboard());
        } else {
            textToUser = "Команда не распознана. Для активации бота напишите /start";
        }


        messageToUser.setText(textToUser);
    }

    public void processInlineButtonClickFromUser(String textFromUser, SendMessage messageToUser) {
        String textToUser = "";

        if (textFromUser.equals(InlineButtonsStorage.TellJoke.getCallBackData())) {
            textToUser = "Заходит однажды к нам в бар улитка и говорит:\n" +
                    "-Можно виски с колой?\n" +
                    "-Простите, но мы не обслуживаем улиток,- сказал я и вышвырнул ее за дверь.\n" +
                    "Через неделю заходит опять эта улитка и спрашивает:\n" +
                    "-Зачем ты это сделал?";
        } else if (textFromUser.equals(InlineButtonsStorage.ShowWeather.getCallBackData())) {
            textToUser = "На улице тепло";
        } else if (textFromUser.equals(InlineButtonsStorage.PlayMusic.getCallBackData())) {
            textToUser = "Ппослушай меня https://music.yandex.ru/";
        }


        messageToUser.setText(textToUser);
    }


}
