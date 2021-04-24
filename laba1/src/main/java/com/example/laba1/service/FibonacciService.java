package com.example.laba1.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {
    public long CalculateValue(int position) {
        long previousNumber = 0;
        long presentNumber = 1;
        long newValue = 0;
        if (position == 0) {
            return newValue;
        } else if (position == 1) {
            newValue = 1;
        } else {
            for (int i = 2; i <= position; i++) {
                newValue = previousNumber + presentNumber;
                previousNumber = presentNumber;
                presentNumber = newValue;
            }
        }
        return newValue;
    }
}
