package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        final Money five = Money.dollar(5);
        final Expression sum = five.plus(five);
        final Bank bank = new Bank();
        final Money reduced = bank.reduce(sum, "USD");
        assertThat(Money.dollar(10)).isEqualTo(reduced);
    }

    @Test
    void testPlusReturnsSum() {
        final Money five = Money.dollar(5);
        final Expression result = five.plus(five);
        final Sum sum = (Sum) result;
        assertThat(five).isEqualTo(sum.augend);
        assertThat(five).isEqualTo(sum.addend);
    }

    @Test
    public void testReduceSum() {
        final Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        final Bank bank = new Bank();
        final Money result = bank.reduce(sum, "USD");
        assertThat(Money.dollar(7)).isEqualTo(result);
    }

    @Test
    void testReduceMoney() {
        final Bank bank = new Bank();
        final Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(Money.dollar(1)).isEqualTo(result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        final Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        final Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(Money.dollar(1)).isEqualTo(result);
    }

    @Test
    void testArrayEquals() {
        assertThat(new Object[]{"abc"}).isEqualTo(new Object[]{"abc"});
    }

    @Test
    void testIdentityRate() {
        assertThat(new Bank().rate("USD", "USD")).isEqualTo(1);
    }

    private interface Expression {
        Money reduce(final Bank bank, String to);
    }

    private static final class Money implements Expression {

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

        public Expression plus(final Money addend) {
            return new Sum(this, addend);
        }

        @Override
        public Money reduce(final Bank bank, final String to) {
            final int rate = bank.rate(currency, to);
            return new Money(amount / rate, to);
        }
    }

    private static class Sum implements Expression {
        final Money augend;
        final Money addend;

        private Sum(final Money money, final Money addend) {
            augend = money;
            this.addend = addend;
        }

        public Money reduce(final Bank bank, final String to) {
            final int amount = augend.amount + addend.amount;
            return new Money(amount, to);
        }
    }

    private class Bank {

        private final Map<Pair, Integer> rates = new HashMap<>();

        public Money reduce(final Expression source, final String to) {
            return source.reduce(this, to);
        }

        public void addRate(final String from, final String to, final int rate) {
            rates.put(new Pair(from, to), rate);
        }

        private int rate(final String from, final String to) {
            if (from.equals(to)) {return 1;}
            final Integer rate = rates.get(new Pair(from, to));
            return rate.intValue();
        }
    }

    private class Pair {
        private final String from;
        private final String to;

        private Pair(final String from, final String to) {
            this.from = from;
            this.to = to;
        }

        public boolean equals(final Object obj) {
            final Pair pair = (Pair) obj;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        public int hashCode() {
            return 0;
        }
    }
}
