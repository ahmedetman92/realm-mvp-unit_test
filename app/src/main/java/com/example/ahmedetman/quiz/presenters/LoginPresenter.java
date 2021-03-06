package com.example.ahmedetman.quiz.presenters;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.models.User;
import com.example.ahmedetman.quiz.models.UserCrud;
import com.example.ahmedetman.quiz.views.fragments.LoginView;

/**
 * Created by Ahmed Etman on 1/30/2018.
 */

public class LoginPresenter {
    private LoginView view;
    private UserCrud userCrud;

    public LoginPresenter(LoginView view, UserCrud userCrud) {
        this.view = view;
        this.userCrud = userCrud;
    }

    public void onLoginClickedMethod() {
        String userEmail = view.getUserEmail();
        String password = view.getPassword();

        if(userEmail.isEmpty() && password.isEmpty()){
            view.showEmptyFieldsErrorMessage(R.string.empty_fields_error_msg);
        }
        if(userEmail.isEmpty()){
            view.showUserNameErrorMsg(R.string.invalid_email_msg);
            return;
        }
        if(password.isEmpty()){
            view.showPasswordErrorMsg(R.string.password_error_msg);
            return;
        }
        boolean login = userCrud.tryToLogin(userEmail,password);
        if(login){
            view.performLoginSuccessAction(userEmail);
            return;
        }
        view.showLoginError(R.string.login_fail_msg);
    }
}
