package org.example.extendAndInterface;

public class Calculator {
    public int result;
    public void add(int num1, int num2) {
        result = num1 + num2;
        System.out.println("(Extends)The sum of the given numbers: " + result);
    }
    public void subtract(int num1, int num2) {
        result = num1 - num2;
        System.out.println("(Extends)The difference between the given numbers: " + result);
    }
    public void multiply(int num1, int num2) {
        result = num1 * num2;
        System.out.println("(Extends)The product of the given numbers: " + result);
    }
}
