package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Daria Zhuravel
 * @date 19.03.18
 **/
public class BotClient extends Client{

    public static void main(String[] args) {
        new BotClient().run();
    }



    @Override
    public void run() {
        super.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random()*100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            //String text = String.format("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message!=null) {
                ConsoleHelper.writeMessage(message);
                String[] arrayText = message.split(": ");
                SimpleDateFormat format = null;

                if (arrayText.length==2 && arrayText[1] != null){
                    String userName = arrayText[0];
                    String textMessage = arrayText[1];

                    switch (textMessage) {
                        case "дата": {
                            format = new SimpleDateFormat("d.MM.YYYY");
                            break;
                        }
                        case "день": {
                            format = new SimpleDateFormat("d");
                            break;
                        }
                        case "месяц": {
                            format = new SimpleDateFormat("MMMM");
                            break;
                        }
                        case "год": {
                            format = new SimpleDateFormat("YYYY");
                            break;
                        }
                        case "время": {
                            format = new SimpleDateFormat("H:mm:ss");
                            break;
                        }
                        case "час": {
                            format = new SimpleDateFormat("H");
                            break;
                        }
                        case "минуты": {
                            format = new SimpleDateFormat("m");
                            break;
                        }
                        case "секунды": {
                            format = new SimpleDateFormat("s");
                            break;
                        }
                    }
                    if (format != null) {
                        sendTextMessage(
                                String.format("Информация для %s: %s", userName
                                        , format.format(Calendar.getInstance().getTime())));
                    }
                }
            }
        }
    }
}
