package com.example.demo;

import org.junit.jupiter.api.Test;

public class DollarTest {

    @Test
    void testMultiplication() {
        final Dollar five = new Dollar(5);
        five.times(2);
        assertEqual(10, five.amout);
    }

    private class Dollar {}
}
