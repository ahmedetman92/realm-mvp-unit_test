package com.example.ahmedetman.quiz.views.activities;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import com.example.ahmedetman.quiz.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Ahmed Etman on 2/2/2018.
 */
public class ActMainTest {

    @Rule
    public ActivityTestRule<ActHome> activityTestRule = new ActivityTestRule<>(ActHome.class);

    private String email ;
    private String password ;

    @Before
    public void setUp() throws Exception {
        email  = "bb";
        password = "@aaaaaaaa";
    }

    @Test
    public void testSuccessLoginScenario(){
        Espresso.onView(withId(R.id.et_login_email)).perform(typeText(email));
        Espresso.onView(withId(R.id.et_login_password)).perform(typeText(password));
        Espresso.onView(withId(R.id.btn_login)).perform(click());
    }
}