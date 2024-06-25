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

    private class Dollar {
        public int amount;

        public Dollar(final int amount) {
            this.amount = amount;
        }

        public void times(final int multipler) {
            amount *= multipler;
        }
    }
}
