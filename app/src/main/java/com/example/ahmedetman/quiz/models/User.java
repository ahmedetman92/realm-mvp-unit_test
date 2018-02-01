package com.example.ahmedetman.quiz.models;

import com.example.ahmedetman.quiz.QuizApp;
import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.Constants;
import com.example.ahmedetman.quiz.helpers.RealmHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Ahmed Etman on 1/27/2018.
 */

public class User extends RealmObject {
    private String firstName;
    private String password;
    private String lastName;
    private String email;
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

    public static class UserCrud {

        public  boolean createUser(User newUser) {

            try {
                Realm realm = RealmHelper.getInstance().initRealm();
                User userObj = realm.createObject(User.class);
                userObj.setFirstName(newUser.getFirstName());
                userObj.setLastName(newUser.getLastName());
                userObj.setPassword(newUser.getPassword());
                userObj.setMobileNumber(newUser.getMobileNumber());
                userObj.setUserType(newUser.getUserType());
                userObj.setEmail(newUser.getEmail());
                realm.commitTransaction();
                realm.close();
                return true;
            }catch (Exception  ex){
                return false;
            }
        }

        public ArrayList<User> retrieveAllUsers() {
            Realm realm = RealmHelper.getInstance().initRealm();
            RealmResults<User> results = realm.where(User.class).findAllAsync();
            results.load();


            ArrayList<User> userArrayList = null;
            if(results != null && results.size() > 0) {
                userArrayList = (ArrayList<User>) realm.copyFromRealm(results);
            }
            realm.close();
            return userArrayList;
        }

        public  boolean tryToLogin(String userEmail, String password){
            boolean result = false;
            if(!userEmail.isEmpty() && !password.isEmpty() && retrieveAllUsers() != null){
                for (User storedUser: retrieveAllUsers()) {
                    if(Objects.equals(userEmail, storedUser.getEmail()) &&
                            Objects.equals(password, storedUser.getPassword())){
                        result = true;
                        break;
                    }
                }
            }
            return result;
        }

        public boolean isUserExists(String email){
            Realm realm = RealmHelper.getInstance().initRealm();
            User user = realm.where(User.class).equalTo("email", email).findFirst();
            realm.close();
            if (user != null) {
                return true;
            } else {
                return false;
            }
        }

        public static String [] provideUserTypes(){
            String [] userTypes = QuizApp.getApplication().getResources().getStringArray(R.array.user_types_array);
            return userTypes;
        }
    }

}
