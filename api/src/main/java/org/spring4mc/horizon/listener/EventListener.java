package org.spring4mc.horizon.listener;

import org.spring4mc.horizon.execution.EventExecutionContext;

@FunctionalInterface
public interface EventListener<E> {
    ListenerResult onEvent(EventExecutionContext<E> event);
}
