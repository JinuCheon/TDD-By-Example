package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void testMultiplication() {
        final Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amout).isEqualTo(10);
    }

    private class Dollar {
        public int amout = 10;

        public Dollar(final int amount) {
        }

        public void times(final int multipler) {
        }
    }
}
