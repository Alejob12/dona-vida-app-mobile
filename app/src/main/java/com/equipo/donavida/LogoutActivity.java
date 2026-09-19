package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.logout_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View sectionHeader = findViewById(R.id.currentSessionSectionHeader);
        ((TextView) sectionHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.logout_section_title);

        View itemCurrentUser = findViewById(R.id.itemCurrentUser);
        ((ImageView) itemCurrentUser.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_drop_logo);
        ((TextView) itemCurrentUser.findViewById(R.id.listItemTitle)).setText(R.string.logout_user_name);
        ((TextView) itemCurrentUser.findViewById(R.id.listItemSubtitle)).setText(R.string.logout_user_email);

        findViewById(R.id.confirmLogoutButton).setOnClickListener(v -> {
            Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        findViewById(R.id.cancelLogoutButton).setOnClickListener(v -> onBackPressed());
    }
}
