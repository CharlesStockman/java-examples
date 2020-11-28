package org.charlesStockman.threads.MultiExector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A prgoram to verify that MultiExecutor can spawn thread a number of thread
 * and then destroy them.
 */

public class MultiExecutor {

    /**
     * Adds a differentiator to make names unique.
     */
    private AtomicInteger differentiator = new AtomicInteger(0);

    /**
     * The first of part of the uniqueName;
     */
    private String className = this.getClass().getSimpleName();


    /**
     * Test to verify that a generic name can be created with a number
     * at the end to make the new name distinct.
     *
     * Does two test : Can the name be generated and after the name is
     * generated can a different name be generated.
     */
    @Test
    public void testGenericNameWithDifferentiator() {

        String resultName1 = "MultiExecutor_0";
        String resultName2 = "MultiExecutor_1";
        String answer, answer2;

        answer = generateUniqueNameWithDifferentiator();
        Assertions.assertEquals(resultName1, answer);

        answer2 = generateUniqueNameWithDifferentiator();
        Assertions.assertEquals(resultName2, answer2);

    }

    /**
     * Create a ThreadFactory and verify that it can set the name of the thread
     */
    public void testSetThreadName() {

        String threadName = generateUniqueNameWithDifferentiator();
        Runnable runnable = () -> System.out.println("Charles Stockman");

        ThreadFactory factory = new ThreadFactorySetName(threadName);
        Thread thread = factory.newThread(runnable);
        Assertions.assertEquals(thread.getName(), threadName);

    }

    /**
     * Test the ability to find a thread by its name
     */
    public void findThreadByName() {
        String name = "Finalizer";

        Set<Thread> threads = findThreadByName();
        Assertions.assertTrue( threads.size() == 1);
        Assertions.assertEquals( threads.iterator().next().getName(), name);
    }

    /**
     * Creates a generic name ( the class name ) with the differentiator
     * ( a number ) that make name unique
     *
     * @return A string that is a unique name
     */
    public String generateUniqueNameWithDifferentiator() {
        String name = className + "_" + differentiator.getAndIncrement();
        return name;
    }
}