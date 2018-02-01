package com.example.ahmedetman.quiz.views.activities;

import android.app.Dialog;
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
import com.example.ahmedetman.quiz.helpers.Utils;
import com.example.ahmedetman.quiz.models.User;

public class ActMain extends AppCompatActivity {

    private User.UserCrud userCrud;
    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvMobile;
    private EditText etPhoneNumber;
    private Button btnEditPhone;
    private Button btnSave;
    private Button btnShowUserType;
    private Context context;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);

        context = this;

        Intent i = getIntent();
        String userEmail = i.getStringExtra("userEmail");
        userCrud =  new User.UserCrud();
        User  user = userCrud.retrieveSingleUser(userEmail);

        initViews(user);
    }

    private void initViews(final User user) {

        tvFirstName = findViewById(R.id.tv_first_name);
        tvLastName = findViewById(R.id.tv_last_name);
        tvMobile = findViewById(R.id.tv_phone);
        btnEditPhone = findViewById(R.id.btn_editphone);
        btnShowUserType = findViewById(R.id.btn_show_user_type);
        linearLayout = findViewById(R.id.linear_layout);


        tvFirstName.setText(user.getFirstName());
        tvLastName.setText(user.getLastName());
        tvMobile.setText(user.getMobileNumber());


        btnEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle(getString(R.string.edit_dialog_title));

                etPhoneNumber = dialog.findViewById(R.id.et_phone);
                btnSave =  dialog.findViewById(R.id.btn_save);
                // if button is clicked, close the custom dialog
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newPhone =  etPhoneNumber.getText().toString();

                        if(Utils.validateMalaysianPhone(newPhone)) {
                            userCrud.updateUser(user, newPhone );
                            dialog.dismiss();
                            Snackbar.make(linearLayout,getString(R.string.phone_edited_success),Snackbar.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(context, getString(R.string.phone_error_msg), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });

        btnShowUserType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, user.getUserType(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
