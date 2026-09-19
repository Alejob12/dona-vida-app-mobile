package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LastDonationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_donation);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.lastDonation_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.lastDonation_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.lastDonation_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.lastDonation_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.lastDonation_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.lastDonation_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.lastDonation_item3_subtitle);

        View sectionCorrection = findViewById(R.id.sectionCorrection);
        ((TextView) sectionCorrection.findViewById(R.id.sectionHeaderTitle)).setText(R.string.lastDonation_section_title);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.lastDonation_note);

        findViewById(R.id.fixDateButton).setOnClickListener(v ->
                Toast.makeText(this, R.string.lastDonation_fix_date_toast, Toast.LENGTH_SHORT).show());

        findViewById(R.id.viewStatusButton).setOnClickListener(v ->
                startActivity(new Intent(LastDonationActivity.this, CurrentStatusActivity.class)));

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.ELEGIBILIDAD);
    }
}
