package org.example.abstraction.abstracts;

import java.sql.SQLOutput;

public abstract class Calculator {

    public void printResult(int a, int b){
        System.out.println("Result: " +this.calculate(a, b));
    }
    public abstract int calculate(int a, int b);
}
