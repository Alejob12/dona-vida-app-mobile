package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VerifyEligibilityActivity extends AppCompatActivity {

    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private CheckBox check5;
    private CheckBox check6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_eligibility);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.verifyEligibility_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.verifyEligibility_stepper_label);
        stepper.findViewById(R.id.stepperSegment2).setBackgroundResource(R.drawable.bg_stepper_filled);
        stepper.findViewById(R.id.stepperSegment3).setBackgroundResource(R.drawable.bg_stepper_filled);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        check6 = findViewById(R.id.check6);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.verifyEligibility_note);

        findViewById(R.id.verifyButton).setOnClickListener(v -> {
            boolean allChecked = check1.isChecked() && check2.isChecked() && check3.isChecked()
                    && check4.isChecked() && check5.isChecked() && check6.isChecked();
            Intent intent = allChecked
                    ? new Intent(VerifyEligibilityActivity.this, UserEligibleActivity.class)
                    : new Intent(VerifyEligibilityActivity.this, UserNotEligibleActivity.class);
            startActivity(intent);
        });
    }
}
