package org.spring4mc.horizon.factory;

import org.spring4mc.horizon.listener.registry.EventSubscription;
import org.springframework.core.ResolvableType;

public interface HorizonEventSubscriptionFactory {
    boolean accepts(ResolvableType eventType);

    EventSubscription<?> create(ResolvableType resolvableType);
}
