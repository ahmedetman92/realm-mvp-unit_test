package com.example.ahmedetman.quiz.models;

import com.example.ahmedetman.quiz.QuizApp;
import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.Constants;
import com.example.ahmedetman.quiz.helpers.RealmHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Ahmed Etman on 1/27/2018.
 */

@SuppressWarnings("serial")
public class User extends RealmObject implements Serializable {

    @PrimaryKey
    @Required
    private String email;
    private String firstName;
    private String password;
    private String lastName;
    private String mobileNumber;
    private String userType;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
