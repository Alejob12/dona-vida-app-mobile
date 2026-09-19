package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SaveChangesLoadingActivity extends AppCompatActivity {

    private static final long LOADING_DELAY_MS = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_changes_loading);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.saveChangesLoading_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SaveChangesLoadingActivity.this, InfoUpdatedActivity.class));
            finish();
        }, LOADING_DELAY_MS);
    }
}
