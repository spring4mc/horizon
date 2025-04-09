package org.spring4mc.horizon.listener.store;

import org.spring4mc.horizon.listener.EventListener;
import org.spring4mc.horizon.listener.registry.EventSubscription;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ListenerStoreByHierarchy<E> extends BaseListenerStore<E> {
    private final Map<Class<? extends E>, SortedEntries<? super E>> store;

    public ListenerStoreByHierarchy() {
        this.store = new ConcurrentHashMap<>();
    }

    public <EVENT extends E> Iterable<EventListener<? super EVENT>> find(Class<EVENT> eventType) {
        final SortedEntries es = this.store.get(eventType);
        if (es == null) {
            return Collections.emptyList();
        }

        return es;
    }

    @Override
    public <EVENT extends E> EventSubscription<EVENT> register(EventListener<EVENT> listener) {
        return null;
    }

    @Override
    public boolean unregister(EventSubscription<? extends E> listener) {
        return false;
    }
}
