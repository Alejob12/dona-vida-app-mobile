package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class SelectDateActivity extends AppCompatActivity {

    private static final int LEADING_EMPTY_CELLS = 1;
    private static final int DAYS_IN_MONTH = 30;
    private static final Set<Integer> AVAILABLE_DAYS = new HashSet<>();
    private static final Set<Integer> PAST_DAYS = new HashSet<>();

    static {
        int[] available = {8, 9, 10, 11, 12, 15, 16, 17};
        for (int day : available) {
            AVAILABLE_DAYS.add(day);
        }
        int[] past = {1, 2, 3, 4, 5};
        for (int day : past) {
            PAST_DAYS.add(day);
        }
    }

    private TextView selectedDayCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.selectDate_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View stepper = findViewById(R.id.stepper);
        ((TextView) stepper.findViewById(R.id.stepperLabel)).setText(R.string.selectDate_stepper_label);
        stepper.findViewById(R.id.stepperSegment2).setBackgroundResource(R.drawable.bg_stepper_filled);
        stepper.findViewById(R.id.stepperSegment3).setBackgroundResource(R.drawable.bg_stepper_filled);
        stepper.findViewById(R.id.stepperSegment4).setBackgroundResource(R.drawable.bg_stepper_filled);

        buildCalendarGrid();

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.selectDate_note);

        View sectionMoreSlots = findViewById(R.id.sectionMoreSlots);
        ((TextView) sectionMoreSlots.findViewById(R.id.sectionHeaderTitle)).setText(R.string.selectDate_section_title);

        RadioGroup quickDateOptions = findViewById(R.id.quickDateOptions);
        quickDateOptions.setOnCheckedChangeListener((group, checkedId) -> clearCalendarSelection());

        findViewById(R.id.continueButton).setOnClickListener(v ->
                startActivity(new Intent(SelectDateActivity.this, SelectTimeActivity.class)));
    }

    private void buildCalendarGrid() {
        GridLayout grid = findViewById(R.id.calendarGrid);
        grid.setColumnCount(7);
        int totalCells = LEADING_EMPTY_CELLS + DAYS_IN_MONTH;
        int rows = (int) Math.ceil(totalCells / 7.0);
        grid.setRowCount(rows);

        int cellSizePx = dp(32);
        int cellMarginPx = dp(1);

        for (int cellIndex = 0; cellIndex < rows * 7; cellIndex++) {
            int row = cellIndex / 7;
            int col = cellIndex % 7;
            int dayNumber = cellIndex - LEADING_EMPTY_CELLS + 1;

            TextView cell = new TextView(this);
            GridLayout.LayoutParams lp = new GridLayout.LayoutParams(
                    GridLayout.spec(row, 1, GridLayout.FILL),
                    GridLayout.spec(col, 1, GridLayout.FILL, 1f));
            lp.width = 0;
            lp.height = cellSizePx;
            lp.setMargins(cellMarginPx, cellMarginPx, cellMarginPx, cellMarginPx);
            cell.setLayoutParams(lp);
            cell.setGravity(Gravity.CENTER);
            cell.setTextAppearance(R.style.TextAppearance_DonaVida_Body);

            if (dayNumber < 1 || dayNumber > DAYS_IN_MONTH) {
                cell.setText("");
                cell.setBackground(null);
            } else {
                cell.setText(String.valueOf(dayNumber));
                if (PAST_DAYS.contains(dayNumber)) {
                    cell.setBackgroundResource(R.drawable.bg_calendar_day_past);
                    cell.setTextColor(getColor(R.color.colorTextSecondary));
                } else if (AVAILABLE_DAYS.contains(dayNumber)) {
                    cell.setBackgroundResource(R.drawable.bg_calendar_day_available);
                    cell.setTextColor(getColor(R.color.colorTextPrimary));
                    cell.setOnClickListener(v -> selectDay(cell));
                } else {
                    cell.setBackgroundResource(R.drawable.bg_calendar_day_unavailable);
                    cell.setTextColor(getColor(R.color.colorTextSecondary));
                }
            }
            grid.addView(cell);
        }
    }

    private void selectDay(TextView cell) {
        if (selectedDayCell != null) {
            selectedDayCell.setBackgroundResource(R.drawable.bg_calendar_day_available);
            selectedDayCell.setTextColor(getColor(R.color.colorTextPrimary));
        }
        cell.setBackgroundResource(R.drawable.bg_calendar_day_selected);
        cell.setTextColor(getColor(R.color.colorWhite));
        selectedDayCell = cell;
        ((RadioGroup) findViewById(R.id.quickDateOptions)).clearCheck();
    }

    private void clearCalendarSelection() {
        if (selectedDayCell != null) {
            selectedDayCell.setBackgroundResource(R.drawable.bg_calendar_day_available);
            selectedDayCell.setTextColor(getColor(R.color.colorTextPrimary));
            selectedDayCell = null;
        }
    }

    private int dp(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
