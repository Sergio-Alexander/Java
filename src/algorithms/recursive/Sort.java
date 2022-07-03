package algorithms.recursive;

public class Sort {

    private static int[] getFirstHalf(int[] data) {
        //TODO : update to get first half of array
        return null;
    }


    private static int[] getSecondHalf(int[] data) {
        //TODO : update to get second half of array
        return null;
    }


    private static void merge(int[] data, int[] left, int[] right) {
        //TODO : update to merge arrays
    }


    public static void mergeSort(int[] data) {
        //TODO : update with algorithm
    }


    private static int partition(int[] data, int low, int high) {
        int mid;
        int pivot;
        boolean done = false;

        mid     = low + (high - low) / 2;
        pivot   = data[mid];

        while (!done){
            // is pivot greater than elements below
            while (data[low] < pivot)
                low++;
            // is pivot less than elements above
            while (data[high] > pivot)
                high--;

            //checking if you are done
            if(low >= high){
                done = true;
            }else{
                swap(data, low, high);
                low++;
                high--;
            }
        }

        return high;
    }


    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }


    private static void quickSort(int[] data, int min, int max) {
        int mid;

        if(min < max){
            // find the partition index
            mid = partition(data, min, max);
            // sort the lower half of list
            quickSort(data, min, mid);
            // sort the upper half of list
            quickSort(data, mid + 1, max);
        }

        // OTHERWISE DO NOTHING (END CASE)

    }


    public static void selectionSort(int[] data) {
        selectionSort(data, 0);
    }


    private static void selectionSort(int[] data, int start) {
        int minIndex;

        if(start < data.length - 1){
            minIndex = start;
            for (int i = start + 1; i < data.length; i++)
                if(data[i] < data[minIndex])
                    minIndex = i;

            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a]  = data[b];
        data[b]  = temp;
    }
}
