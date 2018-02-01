package com.example.ahmedetman.quiz.presenters;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.models.User;
import com.example.ahmedetman.quiz.presenters.RegisterPresenter;
import com.example.ahmedetman.quiz.views.fragments.RegisterView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Ahmed Etman on 1/31/2018.
 */
public class RegisterPresenterTest {


    RegisterPresenter presenter;
    @Mock
    private RegisterView view;
    @Mock
    private User.UserCrud userCrud;

    @Before
    public void setUp() throws Exception {
       presenter  = new RegisterPresenter(view, userCrud);
    }

    @Test
    public void validateEmptyFields() throws Exception {
        when(view.getEmail()).thenReturn("");
        when(view.getPassword()).thenReturn("");
        when(view.getPhone()).thenReturn("");

        presenter.onRegisterClicked();

        verify(view).validateEmptyFields(R.string.empty_fields_error_msg);
    }

}