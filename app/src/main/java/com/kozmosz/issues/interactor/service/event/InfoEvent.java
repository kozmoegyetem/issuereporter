package com.kozmosz.issues.interactor.service.event;

public class InfoEvent extends BaseDamageEvent {
    private EventType eventType;

    public InfoEvent(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
