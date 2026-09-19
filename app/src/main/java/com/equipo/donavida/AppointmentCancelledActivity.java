package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentCancelledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_cancelled);

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.appointmentCancelled_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.appointmentCancelled_banner_body);

        View sectionNext = findViewById(R.id.sectionNext);
        ((TextView) sectionNext.findViewById(R.id.sectionHeaderTitle)).setText(R.string.appointmentCancelled_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.appointmentCancelled_note);

        findViewById(R.id.scheduleAnotherButton).setOnClickListener(v ->
                startActivity(new Intent(AppointmentCancelledActivity.this, ScheduleAppointmentIntroActivity.class)));

        findViewById(R.id.goHomeButton).setOnClickListener(v -> {
            startActivity(new Intent(AppointmentCancelledActivity.this, HomeActivity.class));
            finish();
        });
    }
}
