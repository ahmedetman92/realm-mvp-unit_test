package com.example.ahmedetman.quiz.helpers;

import android.content.Context;

import com.example.ahmedetman.quiz.QuizApp;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Ahmed Etman on 1/27/2018.
 */

public class RealmHelper {

    private static RealmHelper instance = null;
    private Realm realm;

    private RealmHelper() {
    }

    public static RealmHelper getInstance() {
        if (instance == null) {
            instance = new RealmHelper();
        }
        return instance;
    }

    public Realm initRealm() {
        Realm.init(QuizApp.getApplication());

        realm = Realm.getInstance(getRealmConfig());

        realm.beginTransaction();

        return realm;
    }


    private RealmConfiguration getRealmConfig() {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("default2")
                .schemaVersion(2)
                .deleteRealmIfMigrationNeeded()
                .build();
        return config;
    }
}
