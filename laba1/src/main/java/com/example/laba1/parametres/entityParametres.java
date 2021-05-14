package com.example.laba1.parametres;

import com.example.laba1.service.FibonacciService;

public class entityParametres implements Comparable<entityParametres> {
    private int position;
    private long newValue;

    @Override
    public int compareTo(entityParametres parametres) {
        return this.getPosition() - parametres.getPosition();
    }

    public entityParametres(int position){
        this.position = position;
    }

    public entityParametres(int position, long newValue) {
        this.position = position;
        this. newValue = newValue;
    }

    public void Calculate() {
        CalculateFibonacci calculateFibonacci = ()-> {
            long previousNumber = 0;
            long presentNumber = 1;
            if (position == 0) {
                newValue = 0;
            } else if (position == 1) {
                newValue = 1;
            } else {
                for (int i = 2; i <= position; i++) {
                    newValue = previousNumber + presentNumber;
                    previousNumber = presentNumber;
                    presentNumber = newValue;
                }
            }
        };

        calculateFibonacci.calculateValue();
    }

    public int getPosition() { return position; }

    public long getNewValue() { return  newValue; }

    interface CalculateFibonacci {
        void calculateValue();
    }
}
