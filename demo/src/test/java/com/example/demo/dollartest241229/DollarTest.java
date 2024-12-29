package com.example.demo.dollartest241229;

/**
 * 사내스터디 겸 2회독 시작
 */
class DollarTest {

    public void testMultiplication() {
        final Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount).isEqualTo(10);
    }
}
