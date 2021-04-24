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

    public long CalculateFibonacci() {
        FibonacciService fibonacciService = new FibonacciService();
        newValue = fibonacciService.CalculateValue(position);
        return newValue;
    }

    public int getPosition() { return position; }

    public long getNewValue() { return  newValue; }
}
