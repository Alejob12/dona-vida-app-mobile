package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScheduleAppointmentIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appointment_intro);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.scheduleAppointmentIntro_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionSteps = findViewById(R.id.sectionSteps);
        ((TextView) sectionSteps.findViewById(R.id.sectionHeaderTitle)).setText(R.string.scheduleAppointmentIntro_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.scheduleAppointmentIntro_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.scheduleAppointmentIntro_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_check_circle);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.scheduleAppointmentIntro_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.scheduleAppointmentIntro_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_check_circle);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.scheduleAppointmentIntro_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.scheduleAppointmentIntro_item3_subtitle);

        View item4 = findViewById(R.id.item4);
        ((ImageView) item4.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item4.findViewById(R.id.listItemTitle)).setText(R.string.scheduleAppointmentIntro_item4_title);
        ((TextView) item4.findViewById(R.id.listItemSubtitle)).setText(R.string.scheduleAppointmentIntro_item4_subtitle);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.scheduleAppointmentIntro_note);

        findViewById(R.id.goDonateButton).setOnClickListener(v ->
                startActivity(new Intent(ScheduleAppointmentIntroActivity.this, SelectLocationActivity.class)));

        findViewById(R.id.backButtonBottom).setOnClickListener(v ->
                startActivity(new Intent(ScheduleAppointmentIntroActivity.this, HomeActivity.class)));
    }
}
