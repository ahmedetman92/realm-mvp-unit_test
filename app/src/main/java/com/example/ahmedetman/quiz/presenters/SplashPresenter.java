package com.example.ahmedetman.quiz.presenters;


import android.content.Intent;
import android.os.Handler;

import com.example.ahmedetman.quiz.views.activities.ActHome;
import com.example.ahmedetman.quiz.views.activities.ActSplash;
import com.example.ahmedetman.quiz.views.activities.SplashView;

/**
 * Created by Ahmed Etman on 2/1/2018.
 */

public class SplashPresenter {

    private SplashView view;

    public SplashPresenter(SplashView view) {
        this.view = view;
    }

    public void openHome() {
        view.openHomeActivity();
    }
}
