package com.angel.domain.common.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class BaseEvent implements Serializable {

	private UUID eventID;

	private String eventType;

	private LocalDateTime eventTimestamp;

	public BaseEvent(String userCreated) {}

	public BaseEvent(UUID eventID, String eventType, LocalDateTime eventTimeStamp) {
		eventID = UUID.randomUUID();
		this.eventType = eventType;
		eventTimestamp = LocalDateTime.now();
	}

	public UUID getEventID() {
		return eventID;
	}

	public String getEventType() {
		return eventType;
	}

	public LocalDateTime getEventTimestamp() {
		return eventTimestamp;
	}
}
