package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentScheduledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_scheduled);

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.appointmentScheduled_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.appointmentScheduled_banner_body);

        View sectionRemember = findViewById(R.id.sectionRemember);
        ((TextView) sectionRemember.findViewById(R.id.sectionHeaderTitle)).setText(R.string.appointmentScheduled_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.appointmentScheduled_note);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.appointmentScheduled_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentScheduled_item1_subtitle);

        AppState.hasAppointment = true;

        findViewById(R.id.goToAppointmentButton).setOnClickListener(v -> {
            startActivity(new Intent(AppointmentScheduledActivity.this, AppointmentDetailActivity.class));
            finish();
        });

        findViewById(R.id.addToCalendarButton).setOnClickListener(v ->
                Toast.makeText(this, R.string.appointmentScheduled_secondary_button, Toast.LENGTH_SHORT).show());
    }
}
