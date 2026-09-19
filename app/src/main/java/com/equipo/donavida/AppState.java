package com.equipo.donavida;

public final class AppState {

    public static boolean hasAppointment = true;

    /**
     * Figma (33 · Estado actual) muestra "82 de 90 días cumplidos" / "Faltan 8 días",
     * el mismo dato que ya usa HomeActivity — por fidelidad, el estado real es "aún no elegible".
     * Se alterna en cada verificación para que tanto 35 (Elegible) como 37 (No elegible)
     * sigan siendo alcanzables navegando, ya que el flujo de Figma no define un toggle visible.
     */
    public static boolean isEligible = false;

    private AppState() {
    }
}
