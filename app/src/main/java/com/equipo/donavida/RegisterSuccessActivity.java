package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class RegisterSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);

        TextView bannerTitle = findViewById(R.id.bannerTitle);
        TextView bannerBody = findViewById(R.id.bannerBody);
        bannerTitle.setText(R.string.registerSuccess_banner_title);
        bannerBody.setText(R.string.registerSuccess_banner_body);

        MaterialCardView verifyEligibilityItem = findViewById(R.id.verifyEligibilityItem);
        MaterialCardView findPointItem = findViewById(R.id.findPointItem);
        Button goHomeButton = findViewById(R.id.goHomeButton);

        verifyEligibilityItem.setOnClickListener(v ->
                startActivity(new Intent(RegisterSuccessActivity.this, LastDonationActivity.class)));

        findPointItem.setOnClickListener(v ->
                startActivity(new Intent(RegisterSuccessActivity.this, SelectLocationActivity.class)));

        goHomeButton.setOnClickListener(v ->
                startActivity(new Intent(RegisterSuccessActivity.this, HomeActivity.class)));
    }
}
