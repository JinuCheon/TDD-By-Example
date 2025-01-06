package com.example.demo.dollartest241229;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 할 일 목록
 *
 * - [ ] $5+ 10CHF-$10(환율이 2:1일 경우)
 * - [v] $5 × 2=$10
 * - [v] amount를 private으로 만들기
 * - [v] Dollar 부작용(side effect)?
 * - [ ] Money 반올림?
 * - [v] equals()
 * - [ ] hashCode()
 * - [ ] Equals null
 * - [ ] Equals object
 * - [v] 5CHF × 2=10CHF
 * - [ ] Dollar/Franc 중복
 * - [v] 공용 equals
 * - [ ] 공용 times
 * - [v] Franc 와 Dollar 비교하기
 */
class DollarTest {

    @Test
    void testMultiplication() {
        final Money five = Money.dollar(5);
        assertThat(Money.dollar(10).equals(five.times(2))).isTrue();
        assertThat(Money.dollar(15).equals(five.times(3))).isTrue();
    }

    @Test
    void testFrancMultiplication() {
        final Franc five = new Franc(5);
        assertThat(new Franc(10).equals(five.times(2))).isTrue();
        assertThat(new Franc(15).equals(five.times(3))).isTrue();
    }

    @Test
    void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(new Franc(5).equals(new Franc(5))).isTrue();
        assertThat(new Franc(5).equals(new Franc(6))).isFalse();
        assertThat(new Franc(5).equals(Money.dollar(5))).isFalse();
    }
}
