package com.example.ahmedetman.quiz.presenters;

import android.os.Handler;

import com.example.ahmedetman.quiz.helpers.Constants;
import com.example.ahmedetman.quiz.views.activities.SplashView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Ahmed Etman on 2/1/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    @Mock
    private SplashView splashView;
    @Mock
    private SplashPresenter splashPresenter;

    @Before
    public void setUp() throws Exception {
        splashPresenter =  new SplashPresenter(splashView);
    }

    @Test
    public void openHome() throws Exception {
        splashPresenter.openHome();
        verify(splashView,times(1)).openHomeActivity();
//        splashPresenter.openHome(Constants.TIME_OUT);
//    when(handler.postDelayed(any(Runnable.class),anyLong())).thenAnswer(new Answer() {
//        @Override
//        public Object answer(InvocationOnMock invocation) throws Throwable {
//            invocation.getArgumentAt(0, Runnable.class).run();
//            return null;
//        }
//    });
      // verify(splashView,times(1)).openHomeActivity(handler,runnable);
    }

}