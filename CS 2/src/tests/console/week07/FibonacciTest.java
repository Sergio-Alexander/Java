package tests.console.week07;

import static modules.FibModule.print;
import static modules.FibModule.largePrint;
import modules.FibModule;

/*******************************************************************************
 * This Test shows a recursive, iterative and memoized recursive implementation
 * of the Fibonacci Sequence for you to analyze the results.
 *******************************************************************************/
public class FibonacciTest {

    public static void checkIterativeFib(int n){
        System.out.println("\t \t \t I T E R A T I V E   -   ifib(n)");
        System.out.println();
        print(FibModule::ifib, n);
        System.out.println();
    }


    /**********************************************************************
    * Test for iterative Fibonacci for Large N
    **********************************************************************/
    public static void checkLargeNIteration(int n){
        System.out.println("\t \t \t L A R G E  N   -   ifib(n)");
        System.out.println();
        largePrint(FibModule::ifib, n);
        System.out.println();
    }


    /**********************************************************************
    * Test for memoized Fibonacci for Large N
    **********************************************************************/
    public static void checkLargeNMemoization(int n){
        System.out.println("\t \t \t L A R G E  N   -   mfib(n)");
        System.out.println();
        largePrint(FibModule::mfib, n);
        System.out.println();
    }


    /**********************************************************************
     * Test for the standard recursive Fibonacci for Large N
     **********************************************************************/
    public static void checkLargeNRecursion(int n){
        System.out.println("\t \t \t L A R G E  N   -   fib(n)");
        System.out.println();
        largePrint(FibModule::fib, n);
        System.out.println();
    }


    public static void checkMemoizedFib(int n){
        System.out.println("\t \t \t M E M O I Z A T I O N   -   mfib(n)");
        System.out.println();
        print(FibModule::mfib, n);
        System.out.println();
    }


    public static void checkRecursiveFib(int n){
        System.out.println("\t \t \t R E C U R S I V E   -   fib(n)");
        System.out.println();
        print(FibModule::fib, n);
        System.out.println();
    }


    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" F I B O N A C C I    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        intro();
        checkRecursiveFib(11);
        checkMemoizedFib(11);
        checkIterativeFib(11);


        checkLargeNRecursion(21);
        checkLargeNMemoization(21);
        checkLargeNIteration(21);

        checkLargeNRecursion(42);
        checkLargeNMemoization(42);
        checkLargeNIteration(42);


        checkLargeNRecursion(49);
        checkLargeNMemoization(49);
        checkLargeNIteration(49);

        System.out.println("Yes, the results were as expected!");
    }

}
