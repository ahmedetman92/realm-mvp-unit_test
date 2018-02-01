package com.example.ahmedetman.quiz.views.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.models.User;
import com.example.ahmedetman.quiz.presenters.RegisterPresenter;


public class RegisterFragment extends Fragment implements RegisterView{


    private Spinner spinner;
    private RegisterPresenter registerPresenter;
    private Button btnRegister;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private String userType;
    private LinearLayout linearLayout;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        registerPresenter = new RegisterPresenter(this, new User.UserCrud());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        initViews(view);

        return view;
    }

    private void initViews(View view) {
        linearLayout = view.findViewById(R.id.register_layout);
        spinner = view.findViewById(R.id.spinner_user_types);
        btnRegister = view.findViewById(R.id.btn_register);
        etFirstName = view.findViewById(R.id.et_first_name);
        etLastName = view.findViewById(R.id.et_last_name);
        etPassword = view.findViewById(R.id.et_password);
        etPhone = view.findViewById(R.id.et_phone);
        etEmail = view.findViewById(R.id.et_email);
        btnRegister = view.findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPresenter.onRegisterClicked();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,
                User.UserCrud.provideUserTypes());
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                userType = User.UserCrud.provideUserTypes()[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                userType = "";
            }
        });
    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString();
    }

    @Override
    public String getUserType() {
        return userType;
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public String getFirstName() {
        return etFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return etLastName.getText().toString();
    }

    @Override
    public void validateEmptyFields(int empty_fields_error) {
        Snackbar.make(linearLayout,getString(empty_fields_error),Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showPasswordContainsSpecialCharMsg(int special_character_msg) {
        Toast.makeText(getActivity(), getString(special_character_msg), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showPasswordCharactersCountErorMsg(int characters_count_error_msg) {
        Toast.makeText(getActivity(), getString(characters_count_error_msg), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoneErrorMsg(int phone_error_msg) {
        Toast.makeText(getActivity(), getString(phone_error_msg), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegistrationResultsMsg(int registrationSuccess) {
        Toast.makeText(getActivity(), getString(registrationSuccess), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmailAlreadyExistsMsg(int user_exists_msg) {
        Toast.makeText(getActivity(), getString(user_exists_msg), Toast.LENGTH_SHORT).show();
    }

}