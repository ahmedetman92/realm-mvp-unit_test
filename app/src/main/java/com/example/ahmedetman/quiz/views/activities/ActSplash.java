package com.example.ahmedetman.quiz.views.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.Constants;

public class ActSplash extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(ActSplash.this, ActHome.class);
                startActivity(i);

                // close this activity
                finish();
            }
        };

        handler.postDelayed(runnable,Constants.TIME_OUT);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    private Intent loginIntent(Context context){
       return new Intent(context, ActHome.class);
    }
}
