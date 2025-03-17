package com.metropolitan.scheduledactivity.domain.model;

public enum EnumerationActivityState {
    RESERVA(1),
    CANCELAR(2),
    REALIZADO(3),
    AUSENTE(4);

    private final int activityStateId;

    EnumerationActivityState(int activityStateId) {
        this.activityStateId = activityStateId;
    }

    public long getValue() {
        return activityStateId;
    }
}
