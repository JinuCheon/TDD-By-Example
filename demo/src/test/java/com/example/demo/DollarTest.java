package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void testMultiplication() {
        final Dollar five = new Dollar(5);
        assertThat(five.times(2).equals(new Dollar(10))).isTrue();
        assertThat(five.times(2).equals(new Dollar(10))).isTrue();
    }

    @Test
    public void testEquality() {
        assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
        assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
    }

    private class Dollar extends Money {

        public Dollar(final int amount) {
            this.amount = amount;
        }

        public Dollar times(final int multipler) {
            return new Dollar(amount * multipler);
        }

        public boolean equals(final Dollar dollar) {
            return dollar.amount == amount;
        }
    }
}
