package com.example.ahmedetman.quiz.views.fragments;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.Utils;
import com.example.ahmedetman.quiz.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ahmed Etman on 1/31/2018.
 */

class RegisterPresenter {

    private RegisterView view;
    private User.UserCrud userCrud;

    public RegisterPresenter(RegisterView view, User.UserCrud userCrud) {
        this.userCrud = userCrud;
        this.view = view;
    }

    public void onRegisterClicked() {
        String email = view.getEmail();
        String password = view.getPassword();
        String userType = view.getUserType();
        String phone = view.getPhone();
        String firstName = view.getFirstName();
        String lastName = view.getLastName();

        if(validateMandatoryFields(email, password, userType, phone)){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setUserType(userType);
            user.setMobileNumber(phone);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            if(userCrud.createUser(user)){
                view.showRegistrationResultsMsg(R.string.registerationSuccess);
            }else {
                view.showRegistrationResultsMsg(R.string.registerationFailed);
            }
        }
    }

    private boolean validateMandatoryFields(String email, String password, String userType, String phone) {
        if (email.isEmpty() || password.isEmpty() || userType.isEmpty() || phone.isEmpty()) {
            view.validateEmptyFields(R.string.empty_fields_error_msg);
            return false;
        }
        if(validateEmailExistence(email)){
            view.showEmailAlreadyExistsMsg(R.string.user_exists_msg);
            return false;
        }
        if(!validateSpecialCharacters(password)){
            view.showPasswordContainsSpecialCharMsg(R.string.special_character_msg);
            return false;
        }
        if(!validateNumberOfCharacters(password)){
            view.showPasswordCharactersCountErorMsg(R.string.characters_count_error_msg);
            return false;
        }
        if(!Utils.validateMalaysianPhone(phone)){
            view.showPhoneErrorMsg(R.string.phone_error_msg);
            return false;
        }
        return true;
    }

    private boolean validateSpecialCharacters(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateNumberOfCharacters(String str) {
       if(str.length() >= 8){
           return true;
       }
       return false;
    }


    private boolean validateEmailExistence(String email){
        return userCrud.isUserExists(email);
    }
}
