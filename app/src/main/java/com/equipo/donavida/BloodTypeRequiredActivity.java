package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BloodTypeRequiredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_type_required);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.bloodTypeRequired_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.bloodTypeRequired_stepper_label);
        stepper.findViewById(R.id.stepperSegment2).setBackgroundResource(R.drawable.bg_stepper_filled);

        View banner = findViewById(R.id.warningBanner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.bloodTypeRequired_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.bloodTypeRequired_banner_body);

        View confirmTypeHeader = findViewById(R.id.confirmTypeHeader);
        ((TextView) confirmTypeHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.bloodTypeRequired_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.bloodTypeRequired_note);

        findViewById(R.id.continueButton).setOnClickListener(v ->
                startActivity(new Intent(BloodTypeRequiredActivity.this, VerifyEligibilityActivity.class)));

        findViewById(R.id.otherPointsButton).setOnClickListener(v ->
                startActivity(new Intent(BloodTypeRequiredActivity.this, PointsListActivity.class)));
    }
}
