package org.spring4mc.horizon;

import org.spring4mc.horizon.execution.EventExecutionContext;

public interface EventPublisher<E> {
    <EVENT extends E> EventExecutionContext<EVENT> publish(EVENT event);
}