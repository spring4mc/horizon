package org.spring4mc.horizon.factory;

import org.spring4mc.horizon.listener.EventListener;
import org.springframework.core.ResolvableType;

public interface HorizonListenerFactory {
    boolean accepts(Object object);

    boolean accepts(ResolvableType type);

    EventListener<?> create(Object object, ResolvableType resolvableType, Object bean);
}
