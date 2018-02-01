package com.example.ahmedetman.quiz.helpers;

/**
 * Created by Ahmed Etman on 1/27/2018.
 */

public class Constants {

    // Splash screen timer
    public static int TIME_OUT = 5000;

    public static enum UserType {
        Broker("Broker", 0),
        Agent("Agent", 1),
        Dealer("Dealer", 2),
        Private("Private", 3);

        private String stringValue;
        private int intValue;

        private UserType(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }
}
