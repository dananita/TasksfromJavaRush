package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * @author Daria Zhuravel
 * @date 05.04.18
 **/
public class AdvertisementManager {
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        ConsoleHelper.writeMessage("calling processVideos method");
    }
}
