package com.sortmetrics;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testBubbleSort() {
        String[] input = {"Zebra", "Apple", "Mango"};
        String[] expected = {"Apple", "Mango", "Zebra"};
        
        App.bubbleSort(input);
        
        // This checks if our algorithm actually worked!
        assertArrayEquals(expected, input);
    }
}