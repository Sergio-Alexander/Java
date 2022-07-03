package utils;

/**
 * Let's implement a set using a hash table with linear probing.
 * */
public class HashSet<E> implements Set <E>{

    private static final int DEFAULT_CAPACITY = 10;
    private static boolean isREMOVED;

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public HashSet(){
        data = (E[]) new Object[DEFAULT_CAPACITY]; // Instead of E
        size = 0;
        isREMOVED = false;
    }


    /**
     * How do we add an element to the hash table?
     *   - use the hash function to find the proper bucket index.
     *   - if we see a zero (0), put it there.
     *   - if not, move forward until we find an empty (0) index to store it.
     *   - if we see that the value is already in the table , don't re-add it.
     * */
    @Override
    public void add(E item){ // might need to change
        double load_factor = (double) size / data.length;

        if(load_factor >= 0.75){
            rehash();
        }

        // get bucket index
        int index = hash(item);

        //linear probing for empty slot (next available index)
        while (data[index] != null && !data[index].equals(item) && !isREMOVED){
            index = (index + 1) % data.length;
        }

        //avoid duplicates
        if(data[index] == null || !data[index].equals(item)){
            data[index] = item;
            size++;
        }
    }

    @Override
    public void clear(){
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * How do we search for an element to the hash table?
     *   - use the hash function to find the proper bucket index.
     *   - loop forward until we either find the element or an empty index zero (0).
     *   - if we find the element, return true.
     *   - if find zero (0), the element is NOT FOUND, return false.
     * */

    @Override
    public boolean contains(E item){
        // get bucket index
        int index = hash(item);

        //linear probing for empty slot
        while (data[index] != null){
            if(data[index].equals(item)){
                return true;
            }
            index = (index + 1) % data.length;
        }

        return false;  // did we find the item or not?
    }

    private int hash(E item){
        return Math.abs(item.hashCode()) % data.length;
    }


    /**
     * grows hash table to twice its original size
     * - when the hash table get too full, we need to increase to a larger array
     * - we cannot simply "copy" to old array to a new one
     * - uses a load factor (many collections rehash when load factor about 0.75)
     */
    @SuppressWarnings("unchecked")
    private void rehash(){
        // set up reference for old array
        E[] oldArray = data;

        // double the capacity
        int newCapacity = 2 * oldArray.length + 1;

        // update the internal array to new larger array.
        data = (E[]) new Object[newCapacity];
        size = 0;

        //re-add back into new array
        for (int i = 0; i < oldArray.length; i++) {
            if(oldArray[i] != null && !isREMOVED){
                add(oldArray[i]);       // larger array
            }
        }
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * How do we remove an element from the hash table?
     *   - replace element by a "special" removed placeholder value -999.
     * */
    @Override
    public void remove(E item){ // code is wrong, but I don't know where or how to fix
        // get bucket index
        int index = hash(item);

        // linear probing for empty slot
        while (data[index] != null && !data[index].equals(item)){
            index = (index + 1) % data.length;
        }

        // find value and remove it and set flag
        if(data[index].equals(item)){
            data[index] = null;
            isREMOVED   = true;         // "isREMOVED" flag value
            size--;
        }
    }
    @Override
    public int size(){
        return size;
    }

    //FIXME | There is a duplicated item somewhere that I need to find.
    //        Check all add, rehash areas to track the rogue item.
    public String toString(){
        StringBuilder result = new StringBuilder("[" );
        boolean isFirst = true;

        if(!isEmpty()){
            for (int i = 0; i < data.length; i++) {
                E current = data[i];
                if(current != null){
                    if(isFirst){
                        result.append(data[i]);
                        isFirst = false;
                    }else{
                        result.append(", ").append(data[i]);
                    }

                }
            }
        }
        return result + "]";
    }
}
