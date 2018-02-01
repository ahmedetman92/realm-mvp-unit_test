package com.example.ahmedetman.quiz.views.fragments;

/**
 * Created by Ahmed Etman on 1/30/2018.
 */

interface LoginView {
    String getUsername();

    void showUserNameErrorMsg(int user_error_msg_id);

    String getPassword();

    void showPasswordErrorMsg(int password_error_msg_id);

    void showLoginSuccess(int login_success_msg);

    void showLoginError(int login_fail_msg);

    void showEmptyFieldsErrorMessage(int empty_fields_error_msg);
}
