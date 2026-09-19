package com.equipo.donavida;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.PointViewHolder> {

    public static class Point {
        final int titleRes;
        final int subtitleRes;
        final int addressRes;
        final int distanceRes;
        final boolean requiresSpecificType;

        public Point(int titleRes, int subtitleRes, int addressRes, int distanceRes, boolean requiresSpecificType) {
            this.titleRes = titleRes;
            this.subtitleRes = subtitleRes;
            this.addressRes = addressRes;
            this.distanceRes = distanceRes;
            this.requiresSpecificType = requiresSpecificType;
        }
    }

    public interface OnPointClickListener {
        void onPointClick(Point point);
    }

    private final List<Point> points;
    private final OnPointClickListener listener;

    public PointsAdapter(List<Point> points, OnPointClickListener listener) {
        this.points = points;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.partial_list_item, parent, false);
        return new PointViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PointViewHolder holder, int position) {
        Point point = points.get(position);
        holder.icon.setImageResource(R.drawable.ic_place);
        holder.title.setText(point.titleRes);
        holder.subtitle.setText(point.subtitleRes);
        holder.itemView.setOnClickListener(v -> listener.onPointClick(point));

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
        int topMargin = holder.itemView.getResources().getDimensionPixelSize(R.dimen.spacing_xxs);
        params.topMargin = position == 0 ? 0 : topMargin;
        holder.itemView.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return points.size();
    }

    static class PointViewHolder extends RecyclerView.ViewHolder {
        final ImageView icon;
        final TextView title;
        final TextView subtitle;

        PointViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.listItemIcon);
            title = itemView.findViewById(R.id.listItemTitle);
            subtitle = itemView.findViewById(R.id.listItemSubtitle);
        }
    }
}
