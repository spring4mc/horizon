package org.spring4mc.horizon;

import org.spring4mc.horizon.listener.BaseListenerRegistry;
import org.spring4mc.horizon.listener.store.ListenerStoreByHierarchy;

public class Test {

    public static void main(String[] args) {
        final BaseListenerRegistry<TestEvent> registry = new BaseListenerRegistry<>(new ListenerStoreByHierarchy<>());
    }

    interface TestEvent {}
}
