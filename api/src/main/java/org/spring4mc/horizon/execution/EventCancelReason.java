package org.spring4mc.horizon.execution;

public interface EventCancelReason {
    /**
     * Called with whenever {@link org.spring4mc.horizon.listener.registry.ListenerRegistry#close} is called
     */
    static EventCancelReason CLOSE = new EventCancelReason() {};
}
