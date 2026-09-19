package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EligibleToDonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligible_to_donate);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.eligibleToDonate_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.eligibleToDonate_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.eligibleToDonate_banner_body);

        View sectionMeets = findViewById(R.id.sectionMeets);
        ((TextView) sectionMeets.findViewById(R.id.sectionHeaderTitle)).setText(R.string.eligibleToDonate_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.eligibleToDonate_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.eligibleToDonate_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.eligibleToDonate_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.eligibleToDonate_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.eligibleToDonate_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.eligibleToDonate_item3_subtitle);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.eligibleToDonate_note);

        findViewById(R.id.scheduleButton).setOnClickListener(v ->
                startActivity(new Intent(EligibleToDonateActivity.this, ScheduleAppointmentIntroActivity.class)));

        findViewById(R.id.nearbyPointsButton).setOnClickListener(v ->
                startActivity(new Intent(EligibleToDonateActivity.this, PointsListActivity.class)));

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.ELEGIBILIDAD);
    }
}
