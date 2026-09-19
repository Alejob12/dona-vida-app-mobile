package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_summary);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.appointmentSummary_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.appointmentSummary_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentSummary_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.appointmentSummary_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentSummary_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_schedule);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.appointmentSummary_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentSummary_item3_subtitle);

        View item4 = findViewById(R.id.item4);
        ((ImageView) item4.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item4.findViewById(R.id.listItemTitle)).setText(R.string.appointmentSummary_item4_title);
        ((TextView) item4.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentSummary_item4_subtitle);

        View sectionBeforeAppointment = findViewById(R.id.sectionBeforeAppointment);
        ((TextView) sectionBeforeAppointment.findViewById(R.id.sectionHeaderTitle)).setText(R.string.appointmentSummary_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.appointmentSummary_note);

        findViewById(R.id.confirmButton).setOnClickListener(v ->
                startActivity(new Intent(AppointmentSummaryActivity.this, ConfirmAppointmentActivity.class)));

        findViewById(R.id.editButton).setOnClickListener(v ->
                startActivity(new Intent(AppointmentSummaryActivity.this, SelectDateActivity.class)));
    }
}
