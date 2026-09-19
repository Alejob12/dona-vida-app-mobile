package com.equipo.donavida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class PointsListActivity extends AppCompatActivity {

    public static final String EXTRA_POINT_NAME = "point_name";
    public static final String EXTRA_POINT_ADDRESS = "point_address";
    public static final String EXTRA_POINT_DISTANCE = "point_distance";
    public static final String EXTRA_REQUIRES_SPECIFIC_TYPE = "requires_specific_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_list);

        View topAppBar = findViewById(R.id.topAppBar);
        ((TextView) topAppBar.findViewById(R.id.topAppBarTitle)).setText(R.string.pointsList_bar_title);
        topAppBar.findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        View resultsHeader = findViewById(R.id.resultsHeader);
        ((TextView) resultsHeader.findViewById(R.id.sectionHeaderTitle)).setText(R.string.pointsList_results_section);
        TextView sortLink = resultsHeader.findViewById(R.id.sectionHeaderLink);
        sortLink.setText(R.string.pointsList_sort_link);
        sortLink.setVisibility(View.VISIBLE);

        View note = findViewById(R.id.note);
        ((TextView) note.findViewById(R.id.infoNoteText)).setText(R.string.pointsList_note);

        List<PointsAdapter.Point> points = Arrays.asList(
                new PointsAdapter.Point(R.string.pointsList_point1_title, R.string.pointsList_point1_subtitle,
                        R.string.pointDetail_address1, R.string.pointsList_point1_distance, true),
                new PointsAdapter.Point(R.string.pointsList_point2_title, R.string.pointsList_point2_subtitle,
                        R.string.pointDetail_address2, R.string.pointsList_point2_distance, false),
                new PointsAdapter.Point(R.string.pointsList_point3_title, R.string.pointsList_point3_subtitle,
                        R.string.pointDetail_address2, R.string.pointsList_point3_distance, false),
                new PointsAdapter.Point(R.string.pointsList_point4_title, R.string.pointsList_point4_subtitle,
                        R.string.pointDetail_address2, R.string.pointsList_point4_distance, false)
        );

        RecyclerView recyclerView = findViewById(R.id.pointsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PointsAdapter(points, point -> {
            Intent intent = new Intent(PointsListActivity.this, PointDetailActivity.class);
            intent.putExtra(EXTRA_POINT_NAME, getString(point.titleRes));
            intent.putExtra(EXTRA_POINT_ADDRESS, getString(point.addressRes));
            intent.putExtra(EXTRA_POINT_DISTANCE, getString(point.distanceRes));
            intent.putExtra(EXTRA_REQUIRES_SPECIFIC_TYPE, point.requiresSpecificType);
            startActivity(intent);
        }));
    }
}
