package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void testMultiplication() {
        final Money fiveDollar = Money.dollar(5);
        assertThat(fiveDollar.times(2)).isEqualTo(new Dollar(10));
        assertThat(fiveDollar.times(2)).isEqualTo(new Dollar(10));

        final Franc fiveFranc = new Franc(5);
        assertThat(fiveFranc.times(2)).isEqualTo(new Franc(10));
        assertThat(fiveFranc.times(2)).isEqualTo(new Franc(10));
    }

    @Test
    void testEquality() {
        assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
        assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
        assertThat(new Franc(5).equals(new Franc(5))).isTrue();
        assertThat(new Franc(5).equals(new Franc(6))).isFalse();
        assertThat(new Franc(5).equals(new Dollar(5))).isFalse();
    }

    private static class Dollar extends Money {

        public Dollar(final int amount) {
            this.amount = amount;
        }

        public Money times(final int multipler) {
            return new Dollar(amount * multipler);
        }
    }

    private abstract static class Money {
        protected int amount;

        public static Money dollar(final int amount) {
            return new Dollar(amount);
        }

        public boolean equals(final Object object) {
            final Money dollar = (Money) object;
            return amount == dollar.amount
                    && getClass().equals(dollar.getClass());
        }

        public abstract Money times(final int multiplier);
    }

    private class Franc extends Money {

        public Franc(final int amount) {
            this.amount = amount;
        }

        public Money times(final int multipler) {
            return new Franc(amount * multipler);
        }

        public boolean equals(final Franc dollar) {
            return dollar.amount == amount;
        }
    }

}
