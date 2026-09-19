package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView topAppBarTitle = findViewById(R.id.topAppBarTitle);
        topAppBarTitle.setText(R.string.register_title_bar);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());

        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(v ->
                startActivity(new Intent(RegisterActivity.this, CreateProfileActivity.class)));
    }
}
