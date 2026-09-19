package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EligibilityStatusLoadingActivity extends AppCompatActivity {

    private static final long LOADING_DELAY_MS = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility_status_loading);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.eligibilityStatusLoading_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.ELEGIBILIDAD);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            boolean eligibleNow = AppState.isEligible;
            AppState.isEligible = !eligibleNow;
            Class<?> destination = eligibleNow
                    ? EligibleToDonateActivity.class
                    : NotEligibleToDonateActivity.class;
            startActivity(new Intent(EligibilityStatusLoadingActivity.this, destination));
            finish();
        }, LOADING_DELAY_MS);
    }
}
