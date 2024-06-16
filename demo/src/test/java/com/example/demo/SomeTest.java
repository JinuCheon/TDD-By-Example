package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SomeTest {

    @Test
    @DisplayName("Test Hello World")
    void testHelloWorld() {
        final String string = "hello";
        Assertions.assertEquals("hello", string);
    }

}