package org.spring4mc.horizon.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HorizonEventListener {
    /**
     * Read
     * {@link org.spring4mc.horizon.listener.EventListener}
     */
    String condition() default "";
}
