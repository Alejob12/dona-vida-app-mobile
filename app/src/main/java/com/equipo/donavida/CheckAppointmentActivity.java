package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CheckAppointmentActivity extends AppCompatActivity {

    private static final long LOADING_DELAY_MS = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_appointment);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.checkAppointment_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.TURNO);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Class<?> destination = AppState.hasAppointment
                    ? AppointmentDetailActivity.class
                    : NoAppointmentsActivity.class;
            startActivity(new Intent(CheckAppointmentActivity.this, destination));
            finish();
        }, LOADING_DELAY_MS);
    }
}
