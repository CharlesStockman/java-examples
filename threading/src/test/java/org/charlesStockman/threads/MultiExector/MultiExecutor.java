package org.charlesStockman.threads.MultiExector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A prgoram to verify that MultiExecutor can spawn thread a number of thread
 * and then destroy them.
 */

public class MultiExecutor {

    /**
     * Test to verify that a generic name can be created with a number
     * at the end to make the new name distinct.
     *
     * Does two test : Can the name be generated and after the name is
     * generated can a different name be generated.
     */
    @Test
    public void testGenericNameWithDifferentiator() {

        String resultName1 = "MultiExecutor_1";
        String resultName2 = "MultiExecutor_2";
        String answer, answer2;

        answer = generateUniqueNameWithDifferentiator();
        Assertions.assertEquals(resultName1, answer);

        answer2 = generateUniqueNameWithDifferentiator();
        Assertions.assertEquals(resultName2, answer2);

    }


}