package org.example.abstraction.interfaces;

public class Addition implements Calculator{
    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}
