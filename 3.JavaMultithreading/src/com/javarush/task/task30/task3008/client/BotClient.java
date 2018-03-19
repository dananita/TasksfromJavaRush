package com.javarush.task.task30.task3008.client;

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

    }
}
