package com.example.ahmedetman.quiz.views.fragments;

/**
 * Created by Ahmed Etman on 1/31/2018.
 */

interface RegisterView {

    String getEmail();
    String getPhone();
    String getUserType();
    String getPassword();
    String getFirstName();
    String getLastName();

    void validateEmptyFields(int empty_fields_msg);

    void showPasswordContainsSpecialCharMsg(int special_character_msg);

    void showPasswordCharactersCountErorMsg(int characters_count_error_msg);

    void showPhoneErrorMsg(int phone_error_msg);

    void showRegistrationResultsMsg(int registrationSuccess);

    void showEmailAlreadyExistsMsg(int user_exists_msg);
}
