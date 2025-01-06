package com.example.demo.dollartest241229;

public class Franc {
    public int amount;

    Franc(final int amount) {
        this.amount = amount;
    }

    Dollar times(final int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(final Object obj) {
        final Franc dollar = (Franc) obj;
        return amount == dollar.amount;
    }
}
