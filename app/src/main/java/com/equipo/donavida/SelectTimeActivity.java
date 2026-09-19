package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.selectTime_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.selectTime_stepper_label);
        stepper.findViewById(R.id.stepperSegment2).setBackgroundResource(R.drawable.bg_stepper_filled);
        stepper.findViewById(R.id.stepperSegment3).setBackgroundResource(R.drawable.bg_stepper_filled);
        stepper.findViewById(R.id.stepperSegment4).setBackgroundResource(R.drawable.bg_stepper_filled);

        View sectionMorning = findViewById(R.id.sectionMorning);
        ((TextView) sectionMorning.findViewById(R.id.sectionHeaderTitle)).setText(R.string.selectTime_section_morning);

        View sectionAfternoon = findViewById(R.id.sectionAfternoon);
        ((TextView) sectionAfternoon.findViewById(R.id.sectionHeaderTitle)).setText(R.string.selectTime_section_afternoon);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.selectTime_note);

        findViewById(R.id.timeOptionAfternoon2Row).setOnClickListener(v ->
                startActivity(new Intent(SelectTimeActivity.this, NoTimeSlotsActivity.class)));

        findViewById(R.id.confirmButton).setOnClickListener(v ->
                startActivity(new Intent(SelectTimeActivity.this, AppointmentSummaryActivity.class)));

        findViewById(R.id.changeDateButton).setOnClickListener(v ->
                startActivity(new Intent(SelectTimeActivity.this, SelectDateActivity.class)));
    }
}
