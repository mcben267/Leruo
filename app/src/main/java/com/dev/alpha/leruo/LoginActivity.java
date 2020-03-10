package com.dev.alpha.leruo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private Button confirmButton;
    private EditText userPassword;
    private EditText userEmail;
    private TextView signUpLink;

    private String email=null,password=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        confirmButton = findViewById(R.id.signInButton);
        userEmail = findViewById(R.id.emailEditText);
        userPassword = findViewById(R.id.passwordEditText);
        signUpLink = findViewById(R.id.registerTextView);


        confirmButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //execute action
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpLink.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        //code here
        super.onBackPressed();
     }

     public void checkUser(){
        
     }
}
