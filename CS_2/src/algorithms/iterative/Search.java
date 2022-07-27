package algorithms.iterative;

public class Search {

    public static int binarySearch(int[] data, int target){
        int min = 0;
        int max = data.length - 1;
        int mid;

        while(min <= max){
            mid = (min + max) / 2;
            if(data[mid] == target){
                return mid;
            }else if (data[mid] < target) {
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return -1; // ITEM NOT FOUND
    }


    public static boolean contains(int[] data, int target) {
        return indexOf(data, target) != -1;
    }


    public static int indexOf(int[] data, int target) { // (1)  + (1)   excluded in current example
        //                   (1)                                        terminates loop
        //       (1)
        for (int i = 0; i < data.length; i++) {  //  N (iterations)
            //    -- (1) + (1)
            if (data[i] == target)               //    -- (1)           still has to check logic
                return i;
        }
        return -1;                               //  (1)
    }// f(n) = 1 + 1 + N(1 + 1 + 1) + 1 = 3N + 3

}
