package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserNotEligibleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_not_eligible);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.userNotEligible_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.userNotEligible_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.userNotEligible_banner_body);

        View sectionDetail = findViewById(R.id.sectionDetail);
        ((TextView) sectionDetail.findViewById(R.id.sectionHeaderTitle)).setText(R.string.userNotEligible_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.userNotEligible_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.userNotEligible_item1_subtitle);
        item1.setOnClickListener(v ->
                startActivity(new Intent(UserNotEligibleActivity.this, LastDonationActivity.class)));

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.userNotEligible_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.userNotEligible_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.userNotEligible_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.userNotEligible_item3_subtitle);
        item3.setOnClickListener(v ->
                startActivity(new Intent(UserNotEligibleActivity.this, NextAvailableDateActivity.class)));

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.userNotEligible_note);

        findViewById(R.id.reminderButton).setOnClickListener(v ->
                startActivity(new Intent(UserNotEligibleActivity.this, ReminderActivity.class)));

        findViewById(R.id.homeButton).setOnClickListener(v ->
                startActivity(new Intent(UserNotEligibleActivity.this, HomeActivity.class)));
    }
}
