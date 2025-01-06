package com.example.demo.dollartest241229;

abstract class Money {
    protected int amount;

    abstract Money times(int multiplier);

    static Dollar dollar(final int amount) {
        return new Dollar(amount);
    }

    @Override
    public boolean equals(final Object obj) {
        final Money dollar = (Money) obj;
        return amount == dollar.amount
               && getClass().equals(dollar.getClass());
    }
}
