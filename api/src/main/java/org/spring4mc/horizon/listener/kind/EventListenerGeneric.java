package org.spring4mc.horizon.listener.kind;

import org.spring4mc.horizon.listener.EventListener;

public interface EventListenerGeneric<E> extends EventListener<E> {

    default boolean accepts(E event) {
        return true;
    }
}
