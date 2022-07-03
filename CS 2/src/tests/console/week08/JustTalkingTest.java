package tests.console.week08;

public class JustTalkingTest {

    public void search(int[] array, int target){
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if(array[i] == target)
                System.out.println("found value: " + array[i]);
        }
    }


    public int max(int[] array){        //  (1)
        int N = array.length;           //  (1)
        int maxValue = array[0];        //  (1)

             //          (1)            terminates loop
             //  (1)                    initial loop condition
        for (int i = 0; i < N; i++) {   //   N iterations
                                        //     --  (1) + (1)
            if(array[i] > maxValue)     //     --  (1)
                maxValue = array[i];    //     --  (1)
        }

        return maxValue;                //  (1)
    } // f(N) = 1 + 1 + 1 + 1 + 1 + N(1 + 1 + 1 + 1) + 1
      // f(N) = 5 + N(4) + 1 = 4N + 6
      // O(4N + 6) -> O(4N) -> O(N)   "Big" = "Highest"   O = "Order of N"

}
