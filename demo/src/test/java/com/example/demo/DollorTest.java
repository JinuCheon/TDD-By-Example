package com.example.demo;

import org.junit.jupiter.api.Test;

public class DollorTest {

    @Test
    void testMultiplication() {
        final Dollor five = new Dollor(5);
        five.times(2);
        assertEqual(10, five.amout);
    }

    private class Dollor {}
}
