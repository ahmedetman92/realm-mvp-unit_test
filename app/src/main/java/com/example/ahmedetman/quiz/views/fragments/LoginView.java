package com.example.ahmedetman.quiz.views.fragments;

import com.example.ahmedetman.quiz.models.User;

/**
 * Created by Ahmed Etman on 1/30/2018.
 */

public interface LoginView {
    String getUserEmail();

    void showUserNameErrorMsg(int user_error_msg_id);

    String getPassword();

    void showPasswordErrorMsg(int password_error_msg_id);

    void performLoginSuccessAction(String userEmail);

    void showLoginError(int login_fail_msg);

    void showEmptyFieldsErrorMessage(int empty_fields_error_msg);
}
