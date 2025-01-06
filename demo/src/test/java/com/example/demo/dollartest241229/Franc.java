package com.example.demo.dollartest241229;

public class Franc extends Money {

    Franc(final int amount) {
        this.amount = amount;
    }

    Franc times(final int multiplier) {
        return new Franc(amount * multiplier);
    }
}
