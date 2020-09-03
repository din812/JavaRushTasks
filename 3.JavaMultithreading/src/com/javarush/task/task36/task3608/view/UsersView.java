package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;


    @Override
    public void refresh(ModelData modelData) {
        List<User> users = modelData.getUsers();

        System.out.println(modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:");

        users.forEach(user -> {
            System.out.println("\t" + user.getClass().getSimpleName() + "{name='" + user.getName() + "', id="
                                + user.getId() + ", level=" + user.getLevel() + "}");
        });
        System.out.println(new String(new char[51]). replace("\0", "="));

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    @Override
    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }


    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }


}
