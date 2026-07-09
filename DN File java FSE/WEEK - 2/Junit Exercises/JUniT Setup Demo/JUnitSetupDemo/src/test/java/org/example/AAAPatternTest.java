package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AAAPatternTest {

    private int a;
    private int b;

    @Before
    public void setUp() {
        // Runs before every test method
        System.out.println("Setup: initializing values before test...");
        a = 10;
        b = 5;
    }

    @Test
    public void testAddition() {
        // Arrange
        int expected = 15;

        // Act
        int actual = a + b;

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int expected = 5;

        // Act
        int actual = a - b;

        // Assert
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        // Runs after every test method
        System.out.println("Teardown: cleaning up after test...");
        a = 0;
        b = 0;
    }
}