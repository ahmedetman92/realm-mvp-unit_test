package com.example.ahmedetman.quiz.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.models.User;

/* create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements LoginView{

    private LoginPresenter loginPresenter;
    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginPresenter = new LoginPresenter(this, new User.UserCrud());
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        initViews(view);

        // Inflate the layout for this fragment
        return view;
    }

    private void initViews(View view) {
        btnLogin = view.findViewById(R.id.btn_login);
        etPassword = view.findViewById(R.id.et_password);
        etUsername = view.findViewById(R.id.et_user_name);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLoginClickedMethod();
            }
        });
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public void showUserNameErrorMsg(int user_error_msg_id) {
        etUsername.setError(getString(user_error_msg_id));
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showPasswordErrorMsg(int password_error_msg_id) {
        etPassword.setError(getString(password_error_msg_id));
    }

    @Override
    public void showLoginSuccess(int login_success_msg) {
        Toast.makeText(getActivity(), getString(login_success_msg), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError(int login_fail_msg) {
        Toast.makeText(getActivity(), getString(login_fail_msg), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmptyFieldsErrorMessage(int empty_fields_error_msg) {
        Toast.makeText(getActivity(), getString(empty_fields_error_msg), Toast.LENGTH_SHORT).show();
    }
}
