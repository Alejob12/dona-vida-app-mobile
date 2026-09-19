package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PasswordRecoverySentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery_sent);

        TextView bannerTitle = findViewById(R.id.bannerTitle);
        TextView bannerBody = findViewById(R.id.bannerBody);
        bannerTitle.setText(R.string.passwordRecoverySent_banner_title);
        bannerBody.setText(R.string.passwordRecoverySent_banner_body);

        Button resendButton = findViewById(R.id.resendButton);
        Button backToLoginButton = findViewById(R.id.backToLoginButton);

        resendButton.setOnClickListener(v ->
                Toast.makeText(this, R.string.passwordRecoverySent_resend_toast, Toast.LENGTH_SHORT).show());

        backToLoginButton.setOnClickListener(v ->
                startActivity(new Intent(PasswordRecoverySentActivity.this, LoginActivity.class)));
    }
}
