package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NextAvailableDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_available_date);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.nextAvailableDate_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionMeanwhile = findViewById(R.id.sectionMeanwhile);
        ((TextView) sectionMeanwhile.findViewById(R.id.sectionHeaderTitle)).setText(R.string.nextAvailableDate_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_schedule);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.nextAvailableDate_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.nextAvailableDate_item1_subtitle);
        item1.setOnClickListener(v ->
                startActivity(new Intent(NextAvailableDateActivity.this, ReminderActivity.class)));

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_check_circle);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.nextAvailableDate_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.nextAvailableDate_item2_subtitle);
        item2.setOnClickListener(v ->
                startActivity(new Intent(NextAvailableDateActivity.this, VerifyEligibilityActivity.class)));

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.nextAvailableDate_note);

        findViewById(R.id.reminderButton).setOnClickListener(v ->
                startActivity(new Intent(NextAvailableDateActivity.this, ReminderActivity.class)));

        findViewById(R.id.backButton2).setOnClickListener(v -> onBackPressed());
    }
}
