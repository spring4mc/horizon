package org.spring4mc.horizon.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marks class as a container with Listeners, this is better than just annotating methods cause it makes it more performant for scanning of listeners.
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenerContainer {
}
