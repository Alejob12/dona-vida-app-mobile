package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NoAppointmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_appointments);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.noAppointments_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.TURNO);

        View sectionHistory = findViewById(R.id.sectionHistory);
        ((TextView) sectionHistory.findViewById(R.id.sectionHeaderTitle)).setText(R.string.noAppointments_section_title);
        TextView historyLink = sectionHistory.findViewById(R.id.sectionHeaderLink);
        historyLink.setText(R.string.noAppointments_section_link);
        historyLink.setVisibility(View.VISIBLE);
        historyLink.setOnClickListener(v ->
                startActivity(new Intent(NoAppointmentsActivity.this, LastDonationActivity.class)));

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.noAppointments_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.noAppointments_item1_subtitle);
        item1.setOnClickListener(v ->
                startActivity(new Intent(NoAppointmentsActivity.this, LastDonationActivity.class)));

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.noAppointments_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.noAppointments_item2_subtitle);
        item2.setOnClickListener(v ->
                startActivity(new Intent(NoAppointmentsActivity.this, LastDonationActivity.class)));

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.noAppointments_note);

        findViewById(R.id.scheduleButton).setOnClickListener(v ->
                startActivity(new Intent(NoAppointmentsActivity.this, ScheduleAppointmentIntroActivity.class)));
    }
}
