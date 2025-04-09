package org.spring4mc.horizon.listener;

import lombok.RequiredArgsConstructor;
import org.spring4mc.horizon.EventPublisher;
import org.spring4mc.horizon.listener.registry.EventSubscription;
import org.spring4mc.horizon.listener.registry.ListenerRegistry;
import org.spring4mc.horizon.listener.store.BaseListenerStore;

@RequiredArgsConstructor
public class BaseListenerRegistry<E> implements ListenerRegistry<E> {
    private final BaseListenerStore<E> store;

    @Override
    public <EVENT extends E> EventSubscription<EVENT> register(EventListener<EVENT> listener) {
        listener = this.preRegister(listener);

        final EventSubscription<EVENT> subscription = this.store.register(listener);

        return subscription;
    }

    @Override
    public boolean unregister(EventSubscription<? extends E> subscription) {
        return this.store.unregister(subscription);
    }

    @Override
    public void close() {

    }

    @Override
    public void closeAndAwait() {

    }

    @Override
    public EventPublisher<E> publisher() {
        return null;
    }

    protected <EVENT extends E> EventListener<EVENT> preRegister(EventListener<EVENT> listener) {
        return listener;
    }

    protected void cancelUnfinishedContexts() {

    }

    protected void postRegister(EventListener<E> listener) {}
}
