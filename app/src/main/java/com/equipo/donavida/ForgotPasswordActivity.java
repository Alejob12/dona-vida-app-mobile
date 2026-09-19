package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextView topAppBarTitle = findViewById(R.id.topAppBarTitle);
        topAppBarTitle.setText(R.string.forgotPassword_title_bar);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());

        Button submitButton = findViewById(R.id.submitButton);
        Button backToLoginButton = findViewById(R.id.backToLoginButton);

        submitButton.setOnClickListener(v ->
                startActivity(new Intent(ForgotPasswordActivity.this, PasswordRecoverySentActivity.class)));

        backToLoginButton.setOnClickListener(v -> onBackPressed());
    }
}
