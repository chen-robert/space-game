package com.mday.client.game;

import com.mday.client.event.Event;
import com.mday.client.event.EventType;
import com.mday.client.event.type.QuitEvent;
import com.mday.client.ui.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

/**
 * Responsible for managing the game event loop.
 */
public class Runner implements Runnable, Consumer<Event> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    private static final int TARGET_FPS = 60;

    @Nonnull
    private final EventQueue eventQueue;
    @Nonnull
    private final Display display;

    @Nonnull
    private final ScheduledExecutorService scheduledExecutorService;
    @Nonnull
    private final Queue<Consumer<Event>> eventConsumers;

    private ScheduledFuture<?> scheduledFuture = null;

    /**
     * Create an instance of this class.
     *
     * @param eventQueue the event queue that has all of the events that need to be processed
     * @param display the display on which the game will be drawn
     */
    public Runner(@Nonnull final EventQueue eventQueue, @Nonnull final Display display) {
        this.eventQueue = eventQueue;
        this.display = display;
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.eventConsumers = new ConcurrentLinkedQueue<>();
        this.eventConsumers.add(this);
    }

    /**
     * Add the provided event consumer.
     *
     * @param eventConsumer the event consumer that should receive game events
     */
    public void addEventConsumer(@Nonnull final Consumer<Event> eventConsumer) {
        this.eventConsumers.add(eventConsumer);
    }

    /**
     * Start processing events in this runner.
     */
    public void start() {
        final long period = TimeUnit.SECONDS.toNanos(1) / TARGET_FPS;
        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(this, 0L, period, TimeUnit.NANOSECONDS);
    }

    /**
     * Stop this runner.
     */
    public void stop() {
        scheduledFuture.cancel(false);
        scheduledExecutorService.shutdown();
    }

    @Override
    public void run() {
        try {
            consumeEvents();
            updateDisplay();
        } catch (final Exception exception) {
            LOGGER.error("Error in main game loop", exception);
            eventQueue.clear();
            eventQueue.add(new QuitEvent());
            consumeEvents();
        }
    }

    private void consumeEvents() {
        while (!eventQueue.isEmpty()) {
            final Event event = eventQueue.poll();
            if (event != null) {
                eventConsumers.forEach(consumer -> consumer.accept(event));
            }
        }
    }

    private void updateDisplay() {
        display.render();
    }

    @Override
    public void accept(@Nonnull final Event event) {
        if (event.getType() == EventType.QUIT) {
            stop();
        }
    }
}
