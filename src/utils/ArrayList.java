package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 *****************************************************************/
//Updated
public class ArrayList <E> implements List<E>{
    public static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;
    public ArrayList(){
        this(DEFAULT_CAPACITY); // default capacity
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Capacity Cannot be Negative!");
        }
        data = (E[]) new Object[capacity]; // user input
        size = 0;
    }

    public boolean add(E item){
        ensureCapacity(size + 1);
        data[size] = item;
        size++;
        return true;
    }

    public void add(int index, E item) {
        if (index == size) {
            add(item);
        } else{
            checkIndex(index);
            ensureCapacity(size + 1);
            shiftRight(index);
            // put the new one in the right place
            data[index] = item;
            size++;
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("Invalid");
        }
    }

    public void clear(){
        for(int i = size; i != 0; i--){
            data[i] = null;
            size--;
        }
    }

    public boolean contains(E item){
        for(int i = 0 ; i < size ; i++){
            if(data[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int targetCapacity){
        if(targetCapacity > data.length){
            int newCapacity = Math.max(2 * data.length + 1, targetCapacity);
            E[] newArray = (E[]) new Object[newCapacity];
            for(int i = 0; i < data.length; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }

    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E item){
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i]))
                return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E remove(int index){
        checkIndex(index);
        E removedItem = data[index];
        shiftLeft(index);
        data[size - 1] = null;
        size--;
        return removedItem;
    }

    public boolean remove(E item){
        int index = indexOf(item);

        if(contains(item)) {
            remove(index);
            return true;
        }
       return false;
    }

    public E set(int index, E item){
        checkIndex(index);
        E replacedItem  = data[index];
        data[index]     = item;
        return replacedItem;
    }

    private void shiftLeft(int index){
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
    }

    private void shiftRight(int index){
        for(int i = size; i > index; i--){
            data[i] = data[i - 1];
        }
    }

    public int size(){
        return size;
    }

    public String toString(){
        if (isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[" + data[0]);
            for (int i = 1; i < size; i++) {
                result.append(", ").append(data[i]);
            }
            return result + "]";
        }
    }
    public  Iterator<E> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E>{
        int     position;
        boolean isRemovable;
        public ArrayIterator(){
            position    = 0;
            isRemovable = false;
        }
        @Override
        public boolean hasNext() {
            return position < size;
        }
        @Override
        public E next() {
            String message = "There are no items left";
            if(!hasNext()){
                throw new NoSuchElementException(message);
            }
            E currentItem = data[position];
            position++;
            isRemovable   = true;
            return currentItem;
        }
        @Override
        public void remove() {
            String message = "Unable to Remove";
            if(!isRemovable){
                throw new IllegalStateException(message);
            }
            ArrayList.this.remove(position - 1);
            isRemovable = false;
        }
    }
}