package org.spring4mc.horizon.execution;

import java.util.concurrent.CompletableFuture;

public interface EventExecutionContext<EVENT> {
    EVENT event();

    Object await() throws InterruptedException;

    boolean isComplete();

    EventExecutionResult advance();

    /**
     * Fail the current listener
     */
    EventExecutionResult fail(Throwable throwable);

    /**
     * Advance the chain once the given future completes.
     */
    EventExecutionResult advanceOnCompletion(CompletableFuture<?> future);

    interface WithResult<EVENT, RESULT> extends EventExecutionContext<EVENT> {
        @Override
        RESULT await() throws InterruptedException;

        EventExecutionResult advanceWithResult(RESULT result);

        /**
         * Advance the chain once the given future completes with an AtomEventResult.
         */
        EventExecutionResult advanceOnCompletionWithResult(CompletableFuture<RESULT> future);
    }
}
