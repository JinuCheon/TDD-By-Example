package com.example.demo.dollartest241229;

public class Dollar {
    public int amount;

    Dollar(final int amount) {
        this.amount = amount;
    }

    void times(final int multiplier) {
        amount *= multiplier;
    }
}
