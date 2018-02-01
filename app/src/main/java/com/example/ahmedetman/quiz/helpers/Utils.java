package com.example.ahmedetman.quiz.helpers;

/**
 * Created by Ahmed Etman on 2/1/2018.
 */

public class Utils {

    public static boolean validateMalaysianPhone(String phone){
        if( phone.length() > 11 && phone.length() <= 14) {
            String firstCharacters = phone.substring(0, 3);
            if (firstCharacters.contains("+60") || firstCharacters.contains("0060")) {
                return true;
            }
        }
        return false;
    }
}
