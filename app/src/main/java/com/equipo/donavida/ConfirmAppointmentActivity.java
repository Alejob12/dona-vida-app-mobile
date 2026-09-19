package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_appointment);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.confirmAppointment_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionDetail = findViewById(R.id.sectionDetail);
        ((TextView) sectionDetail.findViewById(R.id.sectionHeaderTitle)).setText(R.string.confirmAppointment_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.confirmAppointment_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.confirmAppointment_item1_subtitle);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.confirmAppointment_note);

        findViewById(R.id.confirmButton).setOnClickListener(v ->
                startActivity(new Intent(ConfirmAppointmentActivity.this, AppointmentScheduledActivity.class)));

        findViewById(R.id.cancelButton).setOnClickListener(v -> onBackPressed());
    }
}
