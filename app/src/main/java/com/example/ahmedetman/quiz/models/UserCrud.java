package com.example.ahmedetman.quiz.models;

import com.example.ahmedetman.quiz.QuizApp;
import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.RealmHelper;

import java.util.ArrayList;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Ahmed Etman on 2/2/2018.
 */

public class UserCrud {

    public  boolean createUser(User newUser) {

        try {
            Realm realm = RealmHelper.getInstance().initRealm();
            User userObj = realm.createObject(User.class, newUser.getEmail());
            userObj.setFirstName(newUser.getFirstName());
            userObj.setLastName(newUser.getLastName());
            userObj.setPassword(newUser.getPassword());
            userObj.setMobileNumber(newUser.getMobileNumber());
            userObj.setUserType(newUser.getUserType());

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

    public User retrieveSingleUser(String email){
        Realm realm = RealmHelper.getInstance().initRealm();
        User user = realm.where(User.class).equalTo("email", email).findFirst();
        User newUser1 = new User();
        if (user != null) {

            newUser1.setMobileNumber(user.getMobileNumber());
            newUser1.setLastName(user.getLastName());
            newUser1.setFirstName(user.getFirstName());
            newUser1.setUserType(user.getUserType());
            newUser1.setEmail(user.getEmail());
            newUser1.setPassword(user.getPassword());

            realm.close();
            return newUser1 ;
        }
        return null;
    }

    public boolean updateUser(User userToEdit, String newPhone){
        try{
            Realm realm = RealmHelper.getInstance().initRealm();
            userToEdit.setMobileNumber(newPhone);
            userToEdit.setPassword(userToEdit.getPassword());
            userToEdit.setPassword(userToEdit.getPassword());
            userToEdit.setEmail(userToEdit.getEmail());
            realm.copyToRealmOrUpdate(userToEdit);
            realm.commitTransaction();
            realm.close();
            return true;
        }
        catch (Exception ex){
            return false;
        }
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
