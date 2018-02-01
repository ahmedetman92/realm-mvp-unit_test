package com.example.ahmedetman.quiz.views.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.Constants;
import com.example.ahmedetman.quiz.presenters.SplashPresenter;

public class ActSplash extends AppCompatActivity implements SplashView{

    private SplashPresenter splashPresenter;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_splash);

        splashPresenter = new SplashPresenter(this);

        openHome();
    }

    private void openHome() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                splashPresenter.openHome();
            }
        };

        handler.postDelayed(runnable,Constants.TIME_OUT);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    @Override
    public void openHomeActivity() {
        Intent i = new Intent(ActSplash.this, ActHome.class);
        startActivity(i);

        finish();
    }
}
