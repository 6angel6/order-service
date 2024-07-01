package com.angel.domain.user.events;

import com.angel.domain.common.event.BaseEvent;
import com.angel.domain.common.event.Event;

import java.io.Serializable;
import java.util.UUID;

public class UserCreatedEvent implements Event , Serializable {

	private BaseEvent baseEvent;
	private UUID userID;
	private String username;
	private String firstName;
	private String lastName;
	private String email;

	@Override
	public UUID uniqueAggreagateID() {
		return userID;
	}

	@Override
	public BaseEvent getBaseEvent() {
		return baseEvent;
	}

	public UserCreatedEvent() {
	}

	public UserCreatedEvent(UUID userID, String username, String firstName, String lastName, String email) {
		this.baseEvent = new BaseEvent("UserCreated");
		this.userID = userID;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
