package com.example.demo.dollartest241229;

class Money {
    protected int amount;

    @Override
    public boolean equals(final Object obj) {
        final Money dollar = (Money) obj;
        return amount == dollar.amount;
    }
}
