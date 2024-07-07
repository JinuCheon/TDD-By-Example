package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {

    @Test
    void testMultiplication() {
        final Franc five = new Franc(5);
        assertThat(five.times(2).equals(new Franc(10))).isTrue();
        assertThat(five.times(2).equals(new Franc(10))).isTrue();
    }

    @Test
    public void testEquality() {
        assertThat(new Franc(5).equals(new Franc(5))).isTrue();
        assertThat(new Franc(5).equals(new Franc(6))).isFalse();
    }

    private class Franc {
        private final int amount;

        public Franc(final int amount) {
            this.amount = amount;
        }

        public Franc times(final int multipler) {
            return new Franc(amount * multipler);
        }

        public boolean equals(final Franc dollar) {
            return dollar.amount == amount;
        }
    }
}
