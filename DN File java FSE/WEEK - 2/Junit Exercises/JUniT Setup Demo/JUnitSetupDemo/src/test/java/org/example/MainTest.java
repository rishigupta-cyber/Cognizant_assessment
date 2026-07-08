package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testAddition() {
        System.out.println("JUnit is set up successfully! Running testAddition...");
        int result = 2 + 3;
        assertEquals(5, result);
        System.out.println("Test passed: 2 + 3 = " + result);
    }
}