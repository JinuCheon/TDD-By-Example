package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DollarTest {

    @Test
    void testMultiplication() {
        final Money fiveDollar = Money.dollar(5);
        assertThat(fiveDollar.times(2)).isEqualTo(Money.dollar(10));
        assertThat(fiveDollar.times(2)).isEqualTo(Money.dollar(10));

        final Money fiveFranc = Money.franc(5);
        assertThat(fiveFranc.times(2)).isEqualTo(Money.franc(10));
        assertThat(fiveFranc.times(2)).isEqualTo(Money.franc(10));
    }

    @Test
    void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.franc(5))).isTrue();
    }

    @Test
    void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @Test
    void testSimpleAddition() {
        final Money sum = Money.dollar(5).plus(Money.dollar(5));
        assertThat(sum).isEqualTo(Money.dollar(10));
    }

    private static final class Money {

        final String currency;
        final int amount;

        private Money(final int amount, final String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        static Money dollar(final int amount) {
            return new Money(amount, "USD");
        }

        static Money franc(final int amount) {
            return new Money(amount, "CHF");
        }

        public boolean equals(final Object obj) {
            final Money money = (Money) obj;
            return amount == money.amount
                   && currency().equals(money.currency());
        }

        public Money times(final int multiplier) {
            return new Money(amount * multiplier, currency());
        }

        public String currency() {
            return currency;
        }

        public Money plus(final Money addend) {
            return new Money(amount + addend.amount, currency);
        }
    }

}
