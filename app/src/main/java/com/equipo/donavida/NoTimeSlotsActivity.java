package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NoTimeSlotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_time_slots);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.noTimeSlots_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.noTimeSlots_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.noTimeSlots_banner_body);

        View sectionAlternatives = findViewById(R.id.sectionAlternatives);
        ((TextView) sectionAlternatives.findViewById(R.id.sectionHeaderTitle)).setText(R.string.noTimeSlots_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.noTimeSlots_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.noTimeSlots_item1_subtitle);
        item1.setOnClickListener(v ->
                startActivity(new Intent(NoTimeSlotsActivity.this, SelectTimeActivity.class)));

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.noTimeSlots_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.noTimeSlots_item2_subtitle);
        item2.setOnClickListener(v -> {
            Intent intent = new Intent(NoTimeSlotsActivity.this, PointDetailActivity.class);
            intent.putExtra(PointsListActivity.EXTRA_POINT_NAME, getString(R.string.pointsList_point2_title));
            intent.putExtra(PointsListActivity.EXTRA_POINT_ADDRESS, getString(R.string.pointDetail_address2));
            intent.putExtra(PointsListActivity.EXTRA_POINT_DISTANCE, getString(R.string.pointsList_point2_distance));
            intent.putExtra(PointsListActivity.EXTRA_REQUIRES_SPECIFIC_TYPE, false);
            startActivity(intent);
        });

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.noTimeSlots_note);

        findViewById(R.id.otherDateButton).setOnClickListener(v ->
                startActivity(new Intent(NoTimeSlotsActivity.this, SelectDateActivity.class)));

        findViewById(R.id.otherPointsButton).setOnClickListener(v ->
                startActivity(new Intent(NoTimeSlotsActivity.this, PointsListActivity.class)));
    }
}
