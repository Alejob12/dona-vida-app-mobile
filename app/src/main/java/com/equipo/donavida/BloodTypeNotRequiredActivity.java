package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BloodTypeNotRequiredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_type_not_required);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.bloodTypeNotRequired_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.bloodTypeNotRequired_stepper_label);
        stepper.findViewById(R.id.stepperSegment2).setBackgroundResource(R.drawable.bg_stepper_filled);

        View banner = findViewById(R.id.confirmationBanner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.bloodTypeNotRequired_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.bloodTypeNotRequired_banner_body);

        View demandHeader = findViewById(R.id.demandHeader);
        ((TextView) demandHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.bloodTypeNotRequired_section_title);

        View item1 = findViewById(R.id.demandItem1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.bloodTypeNotRequired_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.bloodTypeNotRequired_item1_subtitle);

        View item2 = findViewById(R.id.demandItem2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.bloodTypeNotRequired_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.bloodTypeNotRequired_item2_subtitle);

        View item3 = findViewById(R.id.demandItem3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.bloodTypeNotRequired_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.bloodTypeNotRequired_item3_subtitle);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.bloodTypeNotRequired_note);

        findViewById(R.id.continueButton).setOnClickListener(v ->
                startActivity(new Intent(BloodTypeNotRequiredActivity.this, VerifyEligibilityActivity.class)));
    }
}
