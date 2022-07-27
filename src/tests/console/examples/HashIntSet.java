package tests.console.examples;

public class HashIntSet {

    private static final int REMOVED = -999;
    private int[] data;
    private int size;

    /**
     * constructs a new empty set
     */
    public HashIntSet(){
        data = new int[10];
        size = 0;
    }

    /**
     * How do we add an element to the hash table?
     *   - use the hash function to find the proper bucket index.
     *   - if we see a zero (0), put it there.
     *   - if not, move forward until we find an empty (0) index to store it.
     *   - if we see that the value is already in the table , don't re-add it.
     *
     * */

    public void add(int item){
        double load_factor = (double) size / data.length;

        if(load_factor >= 0.75){
            rehash();
        }

        // get bucket index
        int index = hash(item);

        //linear probing for empty slot
        while (data[index] != 0 && data[index] != item && data[index] != REMOVED){
            index = (index + 1) % data.length;
        }

        //avoid duplicates
        if(data[index] != item){
            data[index] = index;
            size++;
        }
    }

    public boolean contains(int item){
        // get bucket index
        int index = hash(item);

        //linear probing for empty slot
        while (data[index] != 0 && data[index] != item){
            if(data[index] == item){
                index = (index + 1) % data.length;
            }
        }

        return data[index] == item;       // item not found
    }

    /**
     * hash function maps values to indexes
     */
    private int hash(int value){
        return Math.abs(value) % data.length;
    }

    /**
     * grows hash table to twice its original size
     */
    private void rehash(){
        int[] oldData = data;
        data = new int[2 * oldData.length];
        size = 0;
        for (int i = 0; i < oldData.length; i++) {
            if(data[i] != 0 && data[i] != REMOVED){
                add(data[i]);
            }
        }
    }

    public void remove(int item){
        // get bucket index
        int index = hash(item);

        //linear probing for empty slot
        while (data[index] != 0 && data[index] != item){
            index = (index + 1) % data.length;
        }

        //avoid duplicates
        if(data[index] != item){
            data[index] = -999;     // "isRemoved" flag value
            size--;
        }
    }
}