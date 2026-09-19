package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CreateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        TextView topAppBarTitle = findViewById(R.id.topAppBarTitle);
        topAppBarTitle.setText(R.string.createProfile_title_bar);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());

        AutoCompleteTextView bloodTypeField = findViewById(R.id.bloodTypeField);
        ArrayAdapter<CharSequence> bloodTypeAdapter = ArrayAdapter.createFromResource(
                this, R.array.blood_type_options, android.R.layout.simple_list_item_1);
        bloodTypeField.setAdapter(bloodTypeAdapter);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v ->
                startActivity(new Intent(CreateProfileActivity.this, RegisterSuccessActivity.class)));
    }
}
