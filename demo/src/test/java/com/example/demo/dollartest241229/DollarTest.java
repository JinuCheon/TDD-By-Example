package com.example.demo.dollartest241229;

/**
 * 할 일 목록
 *
 * - [ ] $5+ 10CHF-$10(환율이 2:1일 경우)
 * - [ ] $5 × 2=$10
 * - [ ] amount를 private으로 만들기
 * - [ ] Dollar 부작용(side effect)?
 * - [ ] Money 반올림?
 */
class DollarTest {

    public void testMultiplication() {
        final Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount).isEqualTo(10);
    }
}
