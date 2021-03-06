package com.example.ahmedetman.quiz.views.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmedetman.quiz.R;
import com.example.ahmedetman.quiz.helpers.Constants;
import com.example.ahmedetman.quiz.helpers.Utils;
import com.example.ahmedetman.quiz.models.User;
import com.example.ahmedetman.quiz.models.UserCrud;
import com.example.ahmedetman.quiz.presenters.ActMainPresenter;

import java.util.Timer;
import java.util.TimerTask;

public class ActMain extends AppCompatActivity implements ActMainView {


    private ActMainPresenter actMainPresenter;

    private UserCrud userCrud;
    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvMobile;
    private EditText etPhoneNumber;
    private Button btnEditPhone;
    private Button btnSave;
    private Button btnShowUserType;
    private Button btnLogout;
    private Context context;
    private LinearLayout linearLayout;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);

        actMainPresenter = new ActMainPresenter(this);

        context = this;

        Intent i = getIntent();
        String userEmail = i.getStringExtra("userEmail");
        userCrud = new UserCrud();
        mUser = userCrud.retrieveSingleUser(userEmail);

        initViews(mUser);
    }

    private void initViews(final User user) {

        tvFirstName = findViewById(R.id.tv_first_name);
        tvLastName = findViewById(R.id.tv_last_name);
        tvMobile = findViewById(R.id.tv_phone);
        btnEditPhone = findViewById(R.id.btn_editphone);
        btnShowUserType = findViewById(R.id.btn_show_user_type);
        btnLogout = findViewById(R.id.btn_logout);
        linearLayout = findViewById(R.id.linear_layout);


        tvFirstName.setText(user.getFirstName());
        tvLastName.setText(user.getLastName());
        tvMobile.setText(user.getMobileNumber());


        btnEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actMainPresenter.onEditPhoneClicked();
            }
        });

        btnShowUserType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actMainPresenter.onShowUserTypeClicked();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actMainPresenter.onLogoutClicked();
            }
        });
    }

    @Override
    public void editPhone() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle(getString(R.string.edit_dialog_title));

        etPhoneNumber = dialog.findViewById(R.id.et_phone);
        btnSave =  dialog.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPhone =  etPhoneNumber.getText().toString();

                if(Utils.validateMalaysianPhone(newPhone)) {
                    userCrud.updateUser(mUser, newPhone );
                    dialog.dismiss();
                    Snackbar.make(linearLayout,getString(R.string.phone_edited_success),Snackbar.LENGTH_LONG).show();

                }else{
                    Toast.makeText(context, getString(R.string.phone_error_msg), Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    @Override
    public void showUserType() {
        Toast.makeText(context, mUser.getUserType(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logout() {
        final ProgressDialog dialog = ProgressDialog.show(context, "", getString(R.string.please_wait_text),
                true);
        dialog.show();

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dialog.dismiss();
                t.cancel();
                finish();
                Intent i = new Intent(context, ActSplash.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        }, Constants.TIME_OUT);

    }

}
