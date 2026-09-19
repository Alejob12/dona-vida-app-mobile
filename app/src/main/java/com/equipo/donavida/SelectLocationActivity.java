package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SelectLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.selectLocation_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.selectLocation_stepper_label);

        EditText searchField = findViewById(R.id.searchField);

        View recentHeader = findViewById(R.id.recentHeader);
        ((TextView) recentHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.selectLocation_recent_section);

        View recentItem1 = findViewById(R.id.recentItem1);
        ((ImageView) recentItem1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) recentItem1.findViewById(R.id.listItemTitle)).setText(R.string.selectLocation_recent1_title);
        ((TextView) recentItem1.findViewById(R.id.listItemSubtitle)).setText(R.string.selectLocation_recent1_subtitle);
        recentItem1.setOnClickListener(v -> searchField.setText(R.string.selectLocation_recent1_title));

        View recentItem2 = findViewById(R.id.recentItem2);
        ((ImageView) recentItem2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) recentItem2.findViewById(R.id.listItemTitle)).setText(R.string.selectLocation_recent2_title);
        ((TextView) recentItem2.findViewById(R.id.listItemSubtitle)).setText(R.string.selectLocation_recent2_subtitle);
        recentItem2.setOnClickListener(v -> searchField.setText(R.string.selectLocation_recent2_title));

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.selectLocation_note);

        findViewById(R.id.useCurrentLocationButton).setOnClickListener(v -> {
            searchField.setText(R.string.selectLocation_city_value);
            Toast.makeText(this, R.string.selectLocation_current_location_toast, Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.searchPointsButton).setOnClickListener(v ->
                startActivity(new Intent(SelectLocationActivity.this, PointsListActivity.class)));
    }
}
