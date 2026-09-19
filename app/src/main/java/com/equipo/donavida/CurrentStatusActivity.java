package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CurrentStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.currentStatus_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.currentStatus_stepper_label);
        stepper.findViewById(R.id.stepperSegment2).setBackgroundResource(R.drawable.bg_stepper_filled);
        stepper.findViewById(R.id.stepperSegment3).setBackgroundResource(R.drawable.bg_stepper_filled);

        View sectionDetail = findViewById(R.id.sectionDetail);
        ((TextView) sectionDetail.findViewById(R.id.sectionHeaderTitle)).setText(R.string.currentStatus_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.currentStatus_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.currentStatus_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.currentStatus_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.currentStatus_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.currentStatus_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.currentStatus_item3_subtitle);

        View item4 = findViewById(R.id.item4);
        ((ImageView) item4.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item4.findViewById(R.id.listItemTitle)).setText(R.string.currentStatus_item4_title);
        ((TextView) item4.findViewById(R.id.listItemSubtitle)).setText(R.string.currentStatus_item4_subtitle);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.currentStatus_note);

        findViewById(R.id.viewEligibilityButton).setOnClickListener(v ->
                startActivity(new Intent(CurrentStatusActivity.this, EligibilityStatusLoadingActivity.class)));

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.ELEGIBILIDAD);
    }
}
