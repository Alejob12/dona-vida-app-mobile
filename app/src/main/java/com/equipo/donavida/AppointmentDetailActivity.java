package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_detail);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.appointmentDetail_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        BottomTabBarHelper.bind(this, findViewById(R.id.bottomTabBar), BottomTabBarHelper.Tab.TURNO);

        View banner = findViewById(R.id.banner);
        ((TextView) banner.findViewById(R.id.bannerTitle)).setText(R.string.appointmentDetail_banner_title);
        ((TextView) banner.findViewById(R.id.bannerBody)).setText(R.string.appointmentDetail_banner_body);

        View sectionDetail = findViewById(R.id.sectionDetail);
        ((TextView) sectionDetail.findViewById(R.id.sectionHeaderTitle)).setText(R.string.appointmentDetail_section_title);

        View item1 = findViewById(R.id.item1);
        ((ImageView) item1.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_place);
        ((TextView) item1.findViewById(R.id.listItemTitle)).setText(R.string.appointmentDetail_item1_title);
        ((TextView) item1.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentDetail_item1_subtitle);

        View item2 = findViewById(R.id.item2);
        ((ImageView) item2.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) item2.findViewById(R.id.listItemTitle)).setText(R.string.appointmentDetail_item2_title);
        ((TextView) item2.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentDetail_item2_subtitle);

        View item3 = findViewById(R.id.item3);
        ((ImageView) item3.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_schedule);
        ((TextView) item3.findViewById(R.id.listItemTitle)).setText(R.string.appointmentDetail_item3_title);
        ((TextView) item3.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentDetail_item3_subtitle);

        View item4 = findViewById(R.id.item4);
        ((ImageView) item4.findViewById(R.id.listItemIcon)).setImageResource(R.drawable.ic_event);
        ((TextView) item4.findViewById(R.id.listItemTitle)).setText(R.string.appointmentDetail_item4_title);
        ((TextView) item4.findViewById(R.id.listItemSubtitle)).setText(R.string.appointmentDetail_item4_subtitle);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.appointmentDetail_note);

        findViewById(R.id.rescheduleButton).setOnClickListener(v ->
                startActivity(new Intent(AppointmentDetailActivity.this, RescheduleAppointmentActivity.class)));

        findViewById(R.id.cancelButton).setOnClickListener(v ->
                startActivity(new Intent(AppointmentDetailActivity.this, CancelAppointmentActivity.class)));
    }
}
