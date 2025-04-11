package org.spring4mc.horizon.listener;

import org.spring4mc.horizon.execution.EventExecutionContext;
import org.spring4mc.horizon.execution.EventExecutionResult;

@FunctionalInterface
public interface EventListener<E> {
    EventExecutionResult onEvent(EventExecutionContext<E> event);
}
