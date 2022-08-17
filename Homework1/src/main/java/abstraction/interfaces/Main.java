package abstraction.interfaces;

public class Main {
    public static void main(String[] args) {
        Calculator addition = new Addition();
        Calculator subtraction = new Subtraction();

        System.out.println("Result of addition: "+addition.calculate(2, 1));
        System.out.println("Result of subtraction: "+subtraction.calculate(2,1));
    }
}
