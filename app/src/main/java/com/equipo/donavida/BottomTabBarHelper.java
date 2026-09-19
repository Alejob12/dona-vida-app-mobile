package com.equipo.donavida;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public final class BottomTabBarHelper {

    public enum Tab { DONAR, TURNO, ELEGIBILIDAD, PERFIL }

    private BottomTabBarHelper() {
    }

    public static void bind(final Activity activity, View bottomBarRoot, Tab activeTab) {
        View tabDonar = bottomBarRoot.findViewById(R.id.tabDonar);
        View tabTurno = bottomBarRoot.findViewById(R.id.tabTurno);
        View tabElegibilidad = bottomBarRoot.findViewById(R.id.tabElegibilidad);
        View tabPerfil = bottomBarRoot.findViewById(R.id.tabPerfil);

        tabDonar.setOnClickListener(v -> {
            if (activeTab != Tab.DONAR) {
                activity.startActivity(new Intent(activity, HomeActivity.class));
            }
        });
        tabTurno.setOnClickListener(v -> {
            if (activeTab != Tab.TURNO) {
                activity.startActivity(new Intent(activity, CheckAppointmentActivity.class));
            }
        });
        tabElegibilidad.setOnClickListener(v -> {
            if (activeTab != Tab.ELEGIBILIDAD) {
                activity.startActivity(new Intent(activity, LastDonationActivity.class));
            }
        });
        tabPerfil.setOnClickListener(v -> {
            if (activeTab != Tab.PERFIL) {
                activity.startActivity(new Intent(activity, PersonalDataActivity.class));
            }
        });

        highlight(bottomBarRoot, R.id.tabDonar, activeTab == Tab.DONAR);
        highlight(bottomBarRoot, R.id.tabTurno, activeTab == Tab.TURNO);
        highlight(bottomBarRoot, R.id.tabElegibilidad, activeTab == Tab.ELEGIBILIDAD);
        highlight(bottomBarRoot, R.id.tabPerfil, activeTab == Tab.PERFIL);
    }

    private static void highlight(View bottomBarRoot, int tabContainerId, boolean isActive) {
        View container = bottomBarRoot.findViewById(tabContainerId);
        int color = isActive
                ? container.getResources().getColor(R.color.colorPrimary, container.getContext().getTheme())
                : container.getResources().getColor(R.color.colorTextSecondary, container.getContext().getTheme());

        for (int i = 0; i < ((android.view.ViewGroup) container).getChildCount(); i++) {
            View child = ((android.view.ViewGroup) container).getChildAt(i);
            if (child instanceof ImageView) {
                ((ImageView) child).setColorFilter(color);
            } else if (child instanceof TextView) {
                ((TextView) child).setTextColor(color);
            }
        }
    }
}
