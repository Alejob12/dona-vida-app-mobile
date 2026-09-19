package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoUpdatedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_updated);

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.infoUpdated_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.infoUpdated_banner_body);

        View sectionHeader = findViewById(R.id.sectionAppliedChanges);
        ((TextView) sectionHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.infoUpdated_section_title);

        View itemPhone = findViewById(R.id.itemPhone);
        ((ImageView) itemPhone.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) itemPhone.findViewById(R.id.listItemTitle)).setText(R.string.infoUpdated_item1_title);
        ((TextView) itemPhone.findViewById(R.id.listItemSubtitle)).setText(R.string.infoUpdated_item1_subtitle);

        View itemCity = findViewById(R.id.itemCity);
        ((ImageView) itemCity.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) itemCity.findViewById(R.id.listItemTitle)).setText(R.string.infoUpdated_item2_title);
        ((TextView) itemCity.findViewById(R.id.listItemSubtitle)).setText(R.string.infoUpdated_item2_subtitle);

        findViewById(R.id.backToProfileButton).setOnClickListener(v -> {
            Intent intent = new Intent(InfoUpdatedActivity.this, PersonalDataActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
