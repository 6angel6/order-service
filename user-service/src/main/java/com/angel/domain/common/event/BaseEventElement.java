package com.angel.domain.common.event;

public class BaseEventElement {

	private BaseEvent baseEvent;

	public BaseEventElement() {
	}

	public BaseEventElement(BaseEvent baseEvent) {
		this.baseEvent = baseEvent;
	}

	public BaseEvent getBaseEvent() {
		return baseEvent;
	}

	public void setBaseEvent(BaseEvent baseEvent) {
		this.baseEvent = baseEvent;
	}
}
