package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RescheduleAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reschedule_appointment);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.rescheduleAppointment_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionNewDate = findViewById(R.id.sectionNewDate);
        ((TextView) sectionNewDate.findViewById(R.id.sectionHeaderTitle)).setText(R.string.rescheduleAppointment_date_section_title);

        View sectionNewTime = findViewById(R.id.sectionNewTime);
        ((TextView) sectionNewTime.findViewById(R.id.sectionHeaderTitle)).setText(R.string.rescheduleAppointment_time_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.rescheduleAppointment_note);

        findViewById(R.id.confirmRescheduleButton).setOnClickListener(v -> {
            startActivity(new Intent(RescheduleAppointmentActivity.this, AppointmentRescheduledActivity.class));
            finish();
        });

        findViewById(R.id.backButton3).setOnClickListener(v -> onBackPressed());
    }
}
