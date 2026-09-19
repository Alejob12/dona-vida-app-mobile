package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NotEligibleToDonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_eligible_to_donate);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.notEligibleToDonate_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionReason = findViewById(R.id.sectionReason);
        ((TextView) sectionReason.findViewById(R.id.sectionHeaderTitle)).setText(R.string.notEligibleToDonate_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.notEligibleToDonate_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.notEligibleToDonate_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.notEligibleToDonate_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.notEligibleToDonate_item2_subtitle);
        item2.setOnClickListener(v ->
                startActivity(new Intent(NotEligibleToDonateActivity.this, NextAvailableDateActivity.class)));

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.notEligibleToDonate_note);

        findViewById(R.id.reminderButton).setOnClickListener(v ->
                startActivity(new Intent(NotEligibleToDonateActivity.this, ReminderActivity.class)));

        findViewById(R.id.backButton2).setOnClickListener(v -> onBackPressed());
    }
}
