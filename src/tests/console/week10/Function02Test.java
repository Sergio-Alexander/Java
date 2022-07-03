package tests.console.week10;
import java.util.Scanner;

public class Function02Test {

    public static double add(int x, int y){
        return x + y;
    }

    public static double divide(int x, int y){
        if (x == 0)
            throw new IllegalArgumentException("Cannot Divide by Zero!");

        return (double) y / x;
    }

    public static double multiply(int x, int y){
        return x * y;
    }

    public static double subtract(int x, int y){
        return x - y;
    }

    public static void testingAdd(){
        System.out.println();
        System.out.println("======== Testing Add ==========");
        System.out.println();

        Scanner inputX = new Scanner(System.in);
        System.out.println("Enter variable 'x'");
        int varX = inputX.nextInt();


        Scanner inputY = new Scanner(System.in);
        System.out.println("Enter variable 'y'");
        int varY = inputY.nextInt();

        System.out.println("Variable x added by variable y is " + add(varX, varY));

    }
    public static void testingDivide(){
        System.out.println();
        System.out.println("======== Testing Divide ==========");
        System.out.println();

        Scanner inputX = new Scanner(System.in);
        System.out.println("Enter variable 'x'");
        int varX = inputX.nextInt();


        Scanner inputY = new Scanner(System.in);
        System.out.println("Enter variable 'y'");
        int varY = inputY.nextInt();

        System.out.println("Variable y divided by variable x is " + divide(varX, varY));

    }

    public static void testingMultiply(){
        System.out.println();
        System.out.println("======== Testing Multiply ==========");
        System.out.println();

        Scanner inputX = new Scanner(System.in);
        System.out.println("Enter variable 'x'");
        int varX = inputX.nextInt();


        Scanner inputY = new Scanner(System.in);
        System.out.println("Enter variable 'y'");
        int varY = inputY.nextInt();

        System.out.println("Variable x multiplied by variable y is " + multiply(varX, varY));
    }

    public static void testingSubtract(){
        System.out.println();
        System.out.println("======== Testing Subtract ==========");
        System.out.println();

        Scanner inputX = new Scanner(System.in);
        System.out.println("Enter variable 'x'");
        int varX = inputX.nextInt();


        Scanner inputY = new Scanner(System.in);
        System.out.println("Enter variable 'y'");
        int varY = inputY.nextInt();

        System.out.println("Variable x subtracted by variable y is " + subtract(varX, varY));
    }

    public static void main(String[] args) {
        //TODO: How would you test these functions?

        testingAdd();
        testingMultiply();
        testingDivide();
        testingSubtract();
    }
}

