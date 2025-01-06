package com.example.demo.dollartest241229;

public class Dollar extends Money {
    Dollar(final int amount) {
        this.amount = amount;
    }

    Dollar times(final int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(final Object obj) {
        final Dollar dollar = (Dollar) obj;
        return amount == dollar.amount;
    }
}
