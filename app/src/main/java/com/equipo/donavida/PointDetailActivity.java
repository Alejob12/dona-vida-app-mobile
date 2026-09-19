package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PointDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_detail);

        String name = getIntent().getStringExtra(PointsListActivity.EXTRA_POINT_NAME);
        String address = getIntent().getStringExtra(PointsListActivity.EXTRA_POINT_ADDRESS);
        String distance = getIntent().getStringExtra(PointsListActivity.EXTRA_POINT_DISTANCE);
        boolean requiresSpecificType = getIntent().getBooleanExtra(PointsListActivity.EXTRA_REQUIRES_SPECIFIC_TYPE, false);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(name);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        ((TextView) findViewById(R.id.pointName)).setText(name);
        ((TextView) findViewById(R.id.pointAddress)).setText(address);
        ((TextView) findViewById(R.id.pointDistanceChip)).setText(distance);
        ((TextView) findViewById(R.id.pointTypeChip)).setText(
                requiresSpecificType ? R.string.pointDetail_type_required_chip : R.string.pointDetail_type_any_chip);

        View hoursHeader = findViewById(R.id.hoursHeader);
        ((TextView) hoursHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.pointDetail_hours_section);

        View requirementsHeader = findViewById(R.id.requirementsHeader);
        ((TextView) requirementsHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.pointDetail_requirements_section);

        View urgentNote = findViewById(R.id.urgentNote);
        if (requiresSpecificType) {
            urgentNote.setVisibility(View.VISIBLE);
            ((TextView) urgentNote.findViewById(R.id.infoNoteText)).setText(R.string.pointDetail_urgent_note);
        } else {
            urgentNote.setVisibility(View.GONE);
        }

        View transportItem = findViewById(R.id.transportItem);
        ((ImageView) transportItem.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_directions_car);
        ((TextView) transportItem.findViewById(R.id.listItemTitle)).setText(R.string.pointDetail_transport_title);
        ((TextView) transportItem.findViewById(R.id.listItemSubtitle)).setText(R.string.pointDetail_transport_subtitle);
        transportItem.setOnClickListener(v ->
                Toast.makeText(this, R.string.pointDetail_transport_toast, Toast.LENGTH_SHORT).show());

        findViewById(R.id.scheduleAppointmentButton).setOnClickListener(v -> {
            Intent intent = requiresSpecificType
                    ? new Intent(PointDetailActivity.this, BloodTypeRequiredActivity.class)
                    : new Intent(PointDetailActivity.this, BloodTypeNotRequiredActivity.class);
            startActivity(intent);
        });

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.DONAR);
    }
}
