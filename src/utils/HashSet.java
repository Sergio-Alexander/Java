package utils;

import java.util.Arrays;

public class HashSet<E> implements Set <E>{
    private Object REMOVED = new Object();

    private Object[] data;
    private int size;

    public HashSet(){
        data = (E[]) new Object[10]; // Instead of E
        size = 0;
    }

    @Override
    public void add(E item){ // might need to change
        double load_factor = (double) size / data.length;

        if(load_factor >= 0.75){
            rehash();
        }

        // get bucket index
        int index = hash(item);

        //linear probing for empty slot
        while (data[index] != null && data[index] != item && !data[index].equals(REMOVED)){
            index = (index + 1) % data.length;
        }

        //avoid duplicates
        if(data[index] != item){
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
    @Override
    public boolean contains(E item){
        // get bucket index
        int index = hash(item);

        //linear probing for empty slot
        while (data[index] != null && data[index] != item){
            if(data[index] == item){
                index = (index + 1) % data.length;
            }
        }
        return data[index] == item;
    }

    private int hash(E item){
        return Math.abs(item.hashCode()) % data.length;
    }

    private void rehash(){
        Object[] oldData = data;
        data = (E[]) new Object[2 * oldData.length];
        size = 0;
        for (int i = 0; i < oldData.length; i++) {
            if(data[i] != null && !data[i].equals(REMOVED)){
                add((E) data[i]);
            }
        }
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public void remove(E item){ // code is wrong, but I don't know where or how to fix
        int index = hash(item);
        //linear probing for empty slot
        while (data[index] != null && !data[index].equals(item)){
            index = (index + 1) % data.length;
        }
        //avoid duplicates
        if(data[index].equals(item)){
            data[index] = REMOVED;     // "isRemoved" flag value
            size--;
        }
    }
    @Override
    public int size(){
        return size;
    }

    public String toString(){ // need to fill

        return Arrays.toString(data);
    }
}
