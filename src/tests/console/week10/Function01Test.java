package tests.console.week10;

import functions.F1;
import functions.F2;
import functions.F3;

public class Function01Test {

    public static void main(String[] args) {
        //TODO: Create Method Calls using Functional Programming to
        //      1. TEST THE SQUARE OF A FUNCTION
        testSquareFunction((x) -> (x * x), 2);

        //      2. TEST THE MATH OPERATORS (ADD, SUBTRACT, DIVIDE, MULTIPLY)
        testOperators((x, y) -> (x + y), "Addition"     , "+", 1,7);
        testOperators((x, y) -> (x - y), "Subtraction", "-", 9,3);
        testOperators((x, y) -> (x / y), "Division"  , "/", 6,2);
        testOperators((x, y) -> (x * y), "Multiplication", "*", 4,5);
        //      3. TEST THE VOLUME OF A BOX
        testVolumeOfBox((w, l, h) -> (w * l * h), 2, 2, 2);
        //      4. TEST THE VOLUME OF A CYLINDER
        testVolumeOfCylinder((r, h) -> ( Math.PI * Math.pow(r, 2) * h), 3, 3);
        //      5. TEST THE VOLUME OF A SPHERE
        testVolumeOfSphere((r) -> ((4 * Math.PI * Math.pow(r, 3))/3), 2);

    }

    //TODO: Update To Pass Function and Radius Value
    public static void testSquareFunction(F1 f, int value){
        System.out.println();
        System.out.println("======== R E S U L T S ==========");
        System.out.println();
        System.out.printf("The Square of the value '2' is : ", "PLACE HOLDER");
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println(f.f(value));
    }

    //TODO: Update To Pass Function, Operation Message, Symbol and Values
    public static void testOperators(F2 f, String msg, String op, int x, int y){

        System.out.println();
        System.out.println("============= " + msg + " =============");


        System.out.println();
        if (op.equals("+"))
            System.out.printf("%d %s %d = %.1f", x, op, y, f.f(x,y));
        else if (op.equals("-"))
            System.out.printf("%d %s %d = %.1f", x, op, y, f.f(x,y));
        else if (op.equals("/"))
            System.out.printf("%d %s %d = %.1f", x, op, y, f.f(x,y));
        else if (op.equals("*"))
            System.out.printf("%d %s %d = %.1f", x, op, y, f.f(x,y));

        System.out.println();
        System.out.println("==================================================");
        System.out.println();
    }

    //TODO: Update To Pass Function and Dimension Values
    public static void testVolumeOfBox(F3 f, int width, int length, int height){
        System.out.println();
        System.out.println("======== R E S U L T S==========");
        System.out.println();
        System.out.printf("The volume of the box of width: 2, length 2, and height 2 " +
                          "is: ", "PLACE HOLDER");
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println(f.f(width, length, height));
    }

    //TODO: Update To Pass Function and Dimension Values
    public static void testVolumeOfCylinder(F2 f, int radius, int height){
        System.out.println("======== R E S U L T S==========");
        System.out.println();
        System.out.printf("Volume of cylinder of radius 3 and height 3 " +
                          "is: ", "PLACE HOLDER");
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println(f.f(radius, height));
    }

    //TODO: Update To Pass Function and Radius Value
    public static void testVolumeOfSphere(F1 f, int radius){
        //TODO: Update TO PRINT result to console
        System.out.println("======== R E S U L T S ==========");
        System.out.println();
        System.out.printf("Volume of sphere of radius 2 is: ", "PLACE HOLDER");
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println(f.f(radius));
    }
}

