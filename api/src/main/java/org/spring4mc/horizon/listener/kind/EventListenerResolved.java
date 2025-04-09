package org.spring4mc.horizon.listener.kind;

import org.spring4mc.horizon.listener.EventListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface EventListenerResolved<E> extends EventListener<E> {

    default Class<E> getEventClass() {
        final Type genericInterface = this.getClass().getGenericInterfaces()[0];
        if (genericInterface instanceof ParameterizedType parameterizedType) {
            final Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length > 0 && typeArguments[0] instanceof Class<?>) {
                return (Class<E>) typeArguments[0];
            }
        }

        throw new IllegalStateException("Cannot determine event type from EventListener implementation.");
    }
}
