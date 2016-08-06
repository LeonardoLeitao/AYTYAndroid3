package com.aytycap.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {
    private Button signUp;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mUserName;
    private EditText mPassword;
    private EditText mRetypedPassword;
    private TextView mLink;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.signUp = (Button) findViewById(R.id.signup);
        this.mFirstName = (EditText) findViewById(R.id.firstName);
        this.mLastName = (EditText) findViewById(R.id.lastName);
        this.mUserName = (EditText) findViewById(R.id.username);
        this.mPassword = (EditText) findViewById(R.id.password);
        this.mRetypedPassword = (EditText) findViewById(R.id.retypedPassword);
        this.mLink = (TextView) findViewById(R.id.esqueciSenha);
        this.mLink.setMovementMethod(LinkMovementMethod.getInstance());
        this.user = null;
        this.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpMethod(view);
            }
        });
    }

    private void signUpMethod(View view) {
        String firstName = this.mFirstName.getText().toString();
        String lastName = this.mLastName.getText().toString();
        String userName = this.mUserName.getText().toString();
        String password = this.mPassword.getText().toString();
        String retypedPassword = this.mRetypedPassword.getText().toString();

        boolean ok = true;
        this.user = new User(firstName, lastName, userName, password);


        View focus = null;
        if (TextUtils.isEmpty(firstName)) {
            this.mFirstName.setError("Empty field!");
            focus = this.mFirstName;
            focus.requestFocus();
            ok = false;
        } else {
            ok = true;
        }

        if (TextUtils.isEmpty(lastName)) {
            this.mLastName.setError("Empty field!");
            focus = this.mLastName;
            focus.requestFocus();
            ok = false;
        } else {
            ok = true;
        }

        if (TextUtils.isEmpty(userName)) {
            this.mUserName.setError("Empty field!");
            focus = this.mUserName;
            focus.requestFocus();
            ok = false;
        } else {
            ok = true;
        }

        if (TextUtils.isEmpty(password)) {
            this.mPassword.setError("Empty field!");
            focus = this.mPassword;
            focus.requestFocus();
            ok = false;
        } else if (this.mPassword.length() > 10) {
            this.mPassword.setError("Password length greater than 10!");
            focus = this.mPassword;
            focus.requestFocus();
            ok = false;
        } else {
            ok = true;
        }

        if(TextUtils.isEmpty(retypedPassword)) {
            this.mRetypedPassword.setError("Empty field!");
            focus = this.mRetypedPassword;
            focus.requestFocus();
            ok = false;
        } else if(!retypedPassword.equals(password)) {
            this.mRetypedPassword.setError("Invalid password!");
            focus = this.mRetypedPassword;
            focus.requestFocus();
            ok = false;
        } else {
            ok = true;
        }

        if(ok) {
            Intent intent = new Intent(this, MainActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("username", userName);
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        }

    }
}