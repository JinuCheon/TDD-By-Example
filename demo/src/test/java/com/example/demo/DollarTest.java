package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void testMultiplication() {
        final Dollar five = new Dollar(5);
        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(2)).isEqualTo(new Dollar(10));
    }

    @Test
    public void testEquality() {
        assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
        assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
    }

    private class Dollar {
        public int amount;

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
