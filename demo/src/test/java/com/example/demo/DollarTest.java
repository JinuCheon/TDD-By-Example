package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DollarTest {

    @Test
    void testMultiplication() {
        final Money fiveDollar = Money.dollar(5);
        assertThat(fiveDollar.times(2)).isEqualTo(Money.dollar(10));
        assertThat(fiveDollar.times(2)).isEqualTo(Money.dollar(10));

        final Franc fiveFranc = new Franc(5);
        assertThat(fiveFranc.times(2)).isEqualTo(Money.franc(10));
        assertThat(fiveFranc.times(2)).isEqualTo(Money.franc(10));
    }

    @Test
    void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.franc(5))).isTrue();
        assertThat(Money.franc(5).equals(Money.franc(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.dollar(5))).isFalse();
    }

    @Test
    void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    private abstract static class Money {

        int amount;
        static Money dollar(final int amount) {
            return new Dollar(amount);
        }

        static Money franc(final int amount) {
            return new Franc(amount);
        }

        public boolean equals(final Object obj) {
            final Money dollar = (Money) obj;
            return amount == dollar.amount
                    && getClass().equals(dollar.getClass());
        }

        public abstract Money times(final int multiplier);

    }

    private static final class Dollar extends Money {

        private Dollar(final int amount) {
            this.amount = amount;
        }

        public Money times(final int multiplier) {
            return new Dollar(amount * multiplier);
        }
    }

    private static final class Franc extends Money {


        private Franc(final int amount) {
            this.amount = amount;
        }

        public Money times(final int multiplier) {
            return new Franc(amount * multiplier);
        }

        boolean equals(final Franc dollar) {
            return dollar.amount == amount;
        }
    }

}
