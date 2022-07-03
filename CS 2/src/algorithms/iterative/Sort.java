package algorithms.iterative;

/****************************************************************
 * This module implements recursive algorithms for array 
 * data structures with integer precision.
 ****************************************************************/

public class Sort {

    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if(data[j] < data[j - 1])
                    swap(data, j, j - 1);
            }
        }
    }


    public static void insertionSort(int[] data) {
        int current;
        int j;
        for (int i = 1; i < data.length; i++) {
            current = data[i];
            for (j = i; j > 0 && current < data[j - 1]; j--) {
                data[j] = data[j - 1];
            }
            data[j] = current;
        }
    }

    //This is to find the maximum value in a list/array algorithm
    public static int max(int[] data){
        int n   = data.length;          // (1)      data size
        int max = data[0];              // (1)

        //       (1)
        for(int i = 0; i < n; i++)     // n times
            // (1  + 1)
            if(max < data[i])               // (1)
                max = data[i];              // (1)
        // (1)      terminates loop
        return max;                     // (1)

        // run time function f(n) = 1 + 1 + 1 + n(2 + 1 + 1)
        //                   f(n) = 4n + 5
    }


    public static void selectionSort(int[] data) {
        int minIndex;
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if(data[j] < data[minIndex])
                    minIndex = j;
            }
            if(minIndex != i)
                swap(data, minIndex, i);
        }
    }


    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a]  = data[b];
        data[b]  = temp;
    }
}
