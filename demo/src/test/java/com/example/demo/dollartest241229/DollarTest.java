package com.example.demo.dollartest241229;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 할 일 목록
 *
 * - [ ] $5+ 10CHF-$10(환율이 2:1일 경우)
 * - [v] $5 × 2=$10
 * - [ ] amount를 private으로 만들기
 * - [v] Dollar 부작용(side effect)?
 * - [ ] Money 반올림?
 * - [ ] equals()
 * - [ ] hashCode()
 */
class DollarTest {

    @Test
    void testMultiplication() {
        final Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }
}
