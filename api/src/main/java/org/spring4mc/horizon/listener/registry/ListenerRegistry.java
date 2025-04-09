package org.spring4mc.horizon.listener.registry;

import org.slf4j.helpers.CheckReturnValue;
import org.spring4mc.horizon.EventPublisher;
import org.spring4mc.horizon.listener.EventListener;

/**
 * Listener Registry, where every listener is stored
 * @param <E> The base event
 */
public interface ListenerRegistry<E> {
    /**
     * Registers specified listener
     *
     * @param listener Your listener
     * @return subscription of your listener
     * @param <EVENT> an event that extends the base event class
     */
    @CheckReturnValue
    <EVENT extends E> EventSubscription<EVENT> register(EventListener<EVENT> listener);

    /**
     * Unregister specified subscription
     *
     * @param subscription subscription
     * @return if the listener was contained in this registry or not
     */
    @CheckReturnValue
    boolean unregister(EventSubscription<? extends E> subscription);

    /**
     * Close the registry, cancel all pending contexts
     */
    void close();

    /**
     * Close the registry, await completion of pending contexts
     */
    void closeAndAwait();

    /**
     * Base event publisher configured by the registry
     */
    EventPublisher<E> publisher();
}
