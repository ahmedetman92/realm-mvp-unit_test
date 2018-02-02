package com.example.ahmedetman.quiz.presenters;

import com.example.ahmedetman.quiz.models.UserCrud;
import com.example.ahmedetman.quiz.views.activities.ActMain;
import com.example.ahmedetman.quiz.views.activities.ActMainView;
import com.example.ahmedetman.quiz.views.fragments.LoginView;

/**
 * Created by Ahmed Etman on 2/2/2018.
 */

public class ActMainPresenter {

    private ActMainView view;

    public ActMainPresenter(ActMainView view) {
        this.view = view;
    }

    public void onEditPhoneClicked(){
        view.editPhone();
    }

    public void onShowUserTypeClicked(){
        view.showUserType();
    }

    public void onLogoutClicked(){
        view.logout();
    }
}
