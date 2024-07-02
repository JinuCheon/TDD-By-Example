package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void testMultiplication() {
        final Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
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

        @Override
        public boolean equals(final Object obj) {
            return
        }
    }
}
