package com.example.laba1.parametres;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void CalculateFibonacci() {
        entityParametres parametres = new entityParametres(7);
      //  long actual = parametres.CalculateFibonacci();
        long expected = 13;
       // assertEquals(expected, actual);
    }
}