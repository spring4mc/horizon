package org.spring4mc.horizon.listener.registry;

public interface EventSubscription<E> extends Comparable<EventSubscription<E>> {
    boolean isValid();

    /**
     * Creation Time of the subscription allows to sort without duplicates in very high concurrency applications
     * @return Creation time in nanoseconds of the Subscription
     */
    long creationTime();
}
