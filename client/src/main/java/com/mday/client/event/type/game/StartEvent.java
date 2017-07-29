package com.mday.client.event.type.game;

import com.mday.client.event.Event;

import static com.mday.client.event.EventType.START;

/**
 * Represents the game is starting.
 */
public class StartEvent extends Event {
    /**
     * Create an instance of this event.
     */
    public StartEvent() {
        super(START);
    }
}
