package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CancelAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_appointment);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.cancelAppointment_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionReason = findViewById(R.id.sectionReason);
        ((TextView) sectionReason.findViewById(R.id.sectionHeaderTitle)).setText(R.string.cancelAppointment_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.cancelAppointment_note);

        findViewById(R.id.confirmCancelButton).setOnClickListener(v -> {
            AppState.hasAppointment = false;
            startActivity(new Intent(CancelAppointmentActivity.this, AppointmentCancelledActivity.class));
            finish();
        });

        findViewById(R.id.backButton2).setOnClickListener(v -> onBackPressed());
    }
}
