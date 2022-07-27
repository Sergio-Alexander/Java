package modules;

import functions.Fib;

/****************************************************************
 * This module is included for the Fibonacci Recursion Exercise
 ****************************************************************/
public class FibModule {

    public static long fib(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static long ifib(int n) {
        long x[] = new long[n + 1];
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        x[0] = 0;
        x[1] = 1;
        for (int i = 2; i <= n; i++){
            x[i] = x[i - 1] + x[i - 2];
        }
        return x[n];
    }

    public static long mfib(int n) {
        long x[] = new long[n + 1];
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        memo(n, x);
        return x[n];
    }

    private static long memo(int n, long[] x) {
        if (n <= 1){
            return n;
        }
        if (x[n] != 0){
            return x[n];
        }
        x[n] = (memo(n - 1, x) + memo(n - 2, x));
        return x[n];
    }


    /****************************************************************
     * prints large value sequence in lines. This uses a functional
     * programming approach to print out the data.
     ****************************************************************/
    public static void largePrint(Fib f, int n){
        System.out.println("============ R E S U L T S  ============");
        System.out.println();
        System.out.println();
        System.out.println("====== Large Value Printing Ahead ====== ");
        System.out.println();

        //PRINTS : value for nth factorial
        System.out.println("\t \t n \t \t value");
        for (int i = 0; i <= n; i++ ) {
            String str1 = String.format("\t \t %d \t \t %d \n", i, f.fib(i));
            String str2 = String.format("\t \t %d \t %d \n", i, f.fib(i));

            //TERNARY OPERATOR
            String fString = (i < 10) ? str1 : str2;
            System.out.print(fString);
        }

        System.out.println();
    }


    /****************************************************************
     * prints nth Fibonacci. This uses a functional programming
     * approach to print out the data.
     ****************************************************************/
    public static void print(Fib f, int n){
        System.out.println("============== nth Fibonacci ============");

        // PRINTS : count of nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", i);
        }
        System.out.println();

        //PRINTS : value for nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", f.fib(i));
        }
        System.out.println();
    }

}
