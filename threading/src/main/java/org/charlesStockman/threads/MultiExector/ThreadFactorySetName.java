package org.charlesStockman.threads.MultiExector;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * A specialization of the ThreadFactory that will set the name
 */
public class ThreadFactorySetName implements ThreadFactory {

    // Name of thread to uniquely any thread
    private String threadName;

    public ThreadFactorySetName(String threadName ) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = Executors.defaultThreadFactory().newThread(runnable);
        thread.setName(threadName);
        return thread;
    }
}
