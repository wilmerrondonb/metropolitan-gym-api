package com.metropolitan.scheduledactivity.domain.model;

public enum EnumerationActivityState {
    BOOKING(1),
    PENDING_PAYMENT(2),
    PAID(3),
    ACTIVE(4),
    COMPLETED(5),
    CANCELLED(6);

    private final int activityStateId;

    EnumerationActivityState(int activityStateId) {
        this.activityStateId = activityStateId;
    }

    public long getValue() {
        return activityStateId;
    }
}
