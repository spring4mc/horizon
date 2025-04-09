package org.spring4mc.horizon.execution;

import java.util.concurrent.CompletableFuture;

/**
 * This class is responsible for executing and delegating event execution tasks
 */
public interface EventExecutor {
    CompletableFuture<Void> execute(Runnable runnable);
}
