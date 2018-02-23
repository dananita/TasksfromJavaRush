package com.javarush.task.task36.task3608.model;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 22.02.18
 **/
public interface Model {
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();
}
