package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.home_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View nextAppointmentHeader = findViewById(R.id.nextAppointmentHeader);
        ((TextView) nextAppointmentHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.home_next_appointment_section);
        TextView nextAppointmentLink = nextAppointmentHeader.findViewById(R.id.sectionHeaderLink);
        nextAppointmentLink.setText(R.string.home_next_appointment_link);
        nextAppointmentLink.setVisibility(View.VISIBLE);
        nextAppointmentLink.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, AppointmentDetailActivity.class)));

        View nextAppointmentItem = findViewById(R.id.nextAppointmentItem);
        ((ImageView) nextAppointmentItem.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) nextAppointmentItem.findViewById(R.id.listItemTitle)).setText(R.string.home_next_appointment_title);
        ((TextView) nextAppointmentItem.findViewById(R.id.listItemSubtitle)).setText(R.string.home_next_appointment_subtitle);
        nextAppointmentItem.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, AppointmentDetailActivity.class)));

        View reminderNote = findViewById(R.id.reminderNote);
        ((TextView) reminderNote.findViewById(R.id.infoNoteText)).setText(R.string.home_reminder_note);

        View quickActionsHeader = findViewById(R.id.quickActionsHeader);
        ((TextView) quickActionsHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.home_quick_actions_section);

        View actionDonateItem = findViewById(R.id.actionDonateItem);
        ((ImageView) actionDonateItem.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) actionDonateItem.findViewById(R.id.listItemTitle)).setText(R.string.home_action_donate_title);
        ((TextView) actionDonateItem.findViewById(R.id.listItemSubtitle)).setText(R.string.home_action_donate_subtitle);
        actionDonateItem.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, SelectLocationActivity.class)));

        View actionAppointmentItem = findViewById(R.id.actionAppointmentItem);
        ((ImageView) actionAppointmentItem.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) actionAppointmentItem.findViewById(R.id.listItemTitle)).setText(R.string.home_action_appointment_title);
        ((TextView) actionAppointmentItem.findViewById(R.id.listItemSubtitle)).setText(R.string.home_action_appointment_subtitle);
        actionAppointmentItem.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, CheckAppointmentActivity.class)));

        View actionEligibilityItem = findViewById(R.id.actionEligibilityItem);
        ((ImageView) actionEligibilityItem.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_check_circle);
        ((TextView) actionEligibilityItem.findViewById(R.id.listItemTitle)).setText(R.string.home_action_eligibility_title);
        ((TextView) actionEligibilityItem.findViewById(R.id.listItemSubtitle)).setText(R.string.home_action_eligibility_subtitle);
        actionEligibilityItem.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, LastDonationActivity.class)));

        View actionProfileItem = findViewById(R.id.actionProfileItem);
        ((ImageView) actionProfileItem.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_person);
        ((TextView) actionProfileItem.findViewById(R.id.listItemTitle)).setText(R.string.home_action_profile_title);
        ((TextView) actionProfileItem.findViewById(R.id.listItemSubtitle)).setText(R.string.home_action_profile_subtitle);
        actionProfileItem.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, PersonalDataActivity.class)));

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.DONAR);
    }
}
