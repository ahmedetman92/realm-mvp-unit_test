package com.example.ahmedetman.quiz;

import android.app.Application;

/**
 * Created by Ahmed Etman on 1/27/2018.
 */

public class QuizApp extends Application {

        private static QuizApp instance;
        public static QuizApp getApplication() { return instance; }

        @Override
        public void onCreate() {
            super.onCreate();
            instance = this;
        }
}
