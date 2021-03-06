package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 22.02.18
 **/
public class UsersView implements View{
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        } else if (modelData.isDisplayDeletedUserList()){
            System.out.println("All deleted users:");
        }

        for (User l: modelData.getUsers()
             ) {
            System.out.println("\t" + l.toString());
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() { controller.onShowAllDeletedUsers();}

    public void fireEventOpenUserEditForm(long id) { controller.onOpenUserEditForm(id);
    }

}
