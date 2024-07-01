package com.angel.domain.common.event;

import java.util.UUID;

public interface Event {

	UUID uniqueAggreagateID();

	BaseEvent getBaseEvent();

}
