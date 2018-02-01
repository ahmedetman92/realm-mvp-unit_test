package com.example.ahmedetman.quiz.views.fragments;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.models.User;

/**
 * Created by Ahmed Etman on 1/30/2018.
 */

class LoginPresenter {
    private LoginView view;
    private User.UserCrud userCrud;

    public LoginPresenter(LoginView view, User.UserCrud userCrud) {
        this.view = view;
        this.userCrud = userCrud;
    }

    public void onLoginClickedMethod() {
        String userName = view.getUsername();
        String password = view.getPassword();

        if(userName.isEmpty() && password.isEmpty()){
            view.showEmptyFieldsErrorMessage(R.string.empty_fields_error_msg);
        }
        if(userName.isEmpty()){
            view.showUserNameErrorMsg(R.string.user_error_msg);
            return;
        }
        if(password.isEmpty()){
            view.showPasswordErrorMsg(R.string.password_error_msg);
            return;
        }
        boolean login = userCrud.tryToLogin(userName,password);
        if(login){
            view.showLoginSuccess(R.string.login_success_msg);
            return;
        }
        view.showLoginError(R.string.login_fail_msg);
    }
}
