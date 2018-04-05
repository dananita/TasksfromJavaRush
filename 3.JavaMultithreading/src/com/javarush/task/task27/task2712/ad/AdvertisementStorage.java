package com.javarush.task.task27.task2712.ad;

/**
 * @author Daria Zhuravel
 * @date 05.04.18
 **/
public class AdvertisementStorage {
    private final static AdvertisementStorage instance = new AdvertisementStorage();

    public static synchronized AdvertisementStorage getInstance() {
        return instance;
    }

    private AdvertisementStorage() {
    }
}
