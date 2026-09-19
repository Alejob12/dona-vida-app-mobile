package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView topAppBarTitle = findViewById(R.id.topAppBarTitle);
        topAppBarTitle.setText(R.string.login_title_bar);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());

        Button loginSubmitButton = findViewById(R.id.loginSubmitButton);
        Button forgotPasswordButton = findViewById(R.id.forgotPasswordButton);
        Button registerButton = findViewById(R.id.registerButton);

        loginSubmitButton.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, HomeActivity.class)));

        forgotPasswordButton.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class)));

        registerButton.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }
}
