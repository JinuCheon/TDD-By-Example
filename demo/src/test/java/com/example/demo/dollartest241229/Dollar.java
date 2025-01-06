package com.example.demo.dollartest241229;

public class Dollar extends Money {
    Dollar(final int amount) {
        this.amount = amount;
    }

    static Dollar dollar(final int amount) {
        return new Dollar(amount);
    }

    Money times(final int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
