package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.reminder_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.reminder_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.reminder_banner_body);

        View sectionPreferences = findViewById(R.id.sectionPreferences);
        ((TextView) sectionPreferences.findViewById(R.id.sectionHeaderTitle)).setText(R.string.reminder_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.reminder_note);

        findViewById(R.id.homeButton).setOnClickListener(v ->
                startActivity(new Intent(ReminderActivity.this, HomeActivity.class)));

        findViewById(R.id.viewEligibilityButton).setOnClickListener(v ->
                startActivity(new Intent(ReminderActivity.this, LastDonationActivity.class)));
    }
}
