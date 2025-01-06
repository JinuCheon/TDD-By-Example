package com.example.demo.dollartest241229;

public class Dollar extends Money {
    Dollar(final int amount) {
        this.amount = amount;
    }

    Dollar times(final int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
