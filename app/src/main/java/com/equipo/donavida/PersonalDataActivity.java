package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.personalData_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionHeader = findViewById(R.id.personalDataSectionHeader);
        ((TextView) sectionHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.personalData_section_title);

        bindItem(R.id.itemName, R.drawable.ic_person, R.string.personalData_item1_title, R.string.personalData_item1_subtitle);
        bindItem(R.id.itemEmail, R.drawable.ic_email, R.string.personalData_item2_title, R.string.personalData_item2_subtitle);
        bindItem(R.id.itemPhone, R.drawable.ic_phone, R.string.personalData_item3_title, R.string.personalData_item3_subtitle);
        bindItem(R.id.itemBloodType, R.drawable.ic_drop_logo, R.string.personalData_item4_title, R.string.personalData_item4_subtitle);
        bindItem(R.id.itemCity, R.drawable.ic_place, R.string.personalData_item5_title, R.string.personalData_item5_subtitle);

        findViewById(R.id.editProfileButton).setOnClickListener(v ->
                startActivity(new Intent(PersonalDataActivity.this, EditProfileActivity.class)));

        findViewById(R.id.logoutButton).setOnClickListener(v ->
                startActivity(new Intent(PersonalDataActivity.this, LogoutActivity.class)));

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.PERFIL);
    }

    private void bindItem(int itemId, int iconRes, int titleRes, int subtitleRes) {
        View item = findViewById(itemId);
        ((ImageView) item.findViewById(R.id.listItemIcon)).setImageResource(iconRes);
        ((TextView) item.findViewById(R.id.listItemTitle)).setText(titleRes);
        ((TextView) item.findViewById(R.id.listItemSubtitle)).setText(subtitleRes);
    }
}
