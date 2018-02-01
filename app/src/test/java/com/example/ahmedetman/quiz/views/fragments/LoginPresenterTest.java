package com.example.ahmedetman.quiz.views.fragments;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.models.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Ahmed Etman on 1/30/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {


    LoginPresenter presenter;
    @Mock
    LoginView view;
    @Mock
    User.UserCrud userCrud;


    @Before
    public void setUp() throws Exception {
        presenter =  new LoginPresenter(view, userCrud);
    }


    @Test
    public void showEmptyFieldsErrorMessage(){
        when(view.getUserEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("");

        presenter.onLoginClickedMethod();
        verify(view).showEmptyFieldsErrorMessage(R.string.empty_fields_error_msg);
    }

   @Test
   public void showUsernameErrorMessage(){
        when(view.getUserEmail()).thenReturn("");
        presenter.onLoginClickedMethod();

        verify(view).showUserNameErrorMsg(R.string.user_error_msg);
    }

   @Test
   public void showPasswordErrorMessage(){
        when(view.getUserEmail()).thenReturn("Ahmed");
        when(view.getPassword()).thenReturn("");

        presenter.onLoginClickedMethod();

        verify(view).showPasswordErrorMsg(R.string.password_error_msg);
    }

    @Test
    public void performLoginSuccess() throws Exception {
        when(view.getUserEmail()).thenReturn("Ahmed");
        when(view.getPassword()).thenReturn("Etman");
        when(userCrud.tryToLogin("Ahmed","Etman")).thenReturn(true);
        presenter.onLoginClickedMethod();

        verify(view).performLoginSuccessAction(R.string.login_success_msg);
    }

    @Test
    public void performLoginFail() throws Exception {
        when(view.getUserEmail()).thenReturn("Ahmed");
        when(view.getPassword()).thenReturn("Etman");
        when(userCrud.tryToLogin("Ahmed","Etman")).thenReturn(false);
        presenter.onLoginClickedMethod();

        verify(view).showLoginError(R.string.login_fail_msg);
    }
}