package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 22.02.18
 **/
public class EditUserView implements View{
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
            System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }


    public void fireEventUserDeleted(long id) { controller.onUserDelete(id);}

    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name,id,level);
    }
}
