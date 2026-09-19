package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.editProfile_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionHeader = findViewById(R.id.editProfileSectionHeader);
        ((TextView) sectionHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.editProfile_section_title);

        findViewById(R.id.saveChangesButton).setOnClickListener(v ->
                startActivity(new Intent(EditProfileActivity.this, SaveChangesLoadingActivity.class)));

        findViewById(R.id.discardChangesButton).setOnClickListener(v -> onBackPressed());
    }
}
