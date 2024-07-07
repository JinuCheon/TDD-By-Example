package com.example.demo;

public class Money {
    protected int amount;

    public boolean equals(final Object object) {
        final Money dollar = (Money) object;
        return amount == dollar.amount;
    }
}
