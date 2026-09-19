package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentRescheduledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_rescheduled);

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.appointmentRescheduled_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.appointmentRescheduled_banner_body);

        View sectionApplied = findViewById(R.id.sectionApplied);
        ((TextView) sectionApplied.findViewById(R.id.sectionHeaderTitle)).setText(R.string.appointmentRescheduled_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.appointmentRescheduled_note);

        findViewById(R.id.goToAppointmentButton2).setOnClickListener(v -> {
            startActivity(new Intent(AppointmentRescheduledActivity.this, AppointmentDetailActivity.class));
            finish();
        });

        findViewById(R.id.goHomeButton2).setOnClickListener(v -> {
            startActivity(new Intent(AppointmentRescheduledActivity.this, HomeActivity.class));
            finish();
        });
    }
}
