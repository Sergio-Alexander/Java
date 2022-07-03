package utils;

/**
 * Let's implement a set using a hash table.
 * The hash table uses separate chaining to resolve collisions
 * by storing a list at each index.
 * */
public class HashMap <K,V> implements Map <K,V>{

    private static final double MAX_LOAD_FACTOR = 0.75;

    private static final int DEFAULT_CAPACITY = 10;
    private Node<K,V>[] array;
    private int size;


    /**
     * constructs a new empty map
     */
    @SuppressWarnings("unchecked")
    public HashMap(){
        array = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * removes all elements from the set
     */
    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;

    }

    /**
     * How do we search for an element to the hash table?
     *   - loop through list for index with corresponding value.
     *   - if we find the element, return true.
     * */
    @Override
    public boolean containsKey(K key) {
        int index = hash(key);

        for(Node<K,V> node = array[index]; node != null; node = node.next){
            if(node.key.equals(key)){
                return true;
            }
        }

        return false;       // NOT FOUND
    }

    /**
     * hash function maps values to index
     * returns the preferred hash bucket index for the given value.
     */
    private int hash(K key){
        return Math.abs(key.hashCode()) % array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private double loadFactor() {
        return (double) size / array.length;
    }

    /**
     * resizes the hash table to twice its original size.
     * - when the hash table get too full, we need to increase to a larger array
     * - we cannot simply "copy" to old array to a new one
     * - uses a load factor (many collections rehash when load factor about 0.75)
     */
    @SuppressWarnings("unchecked")
    private void rehash(){
        int newCapacity       = 2 * array.length + 1;
        Node<K,V>[] oldArray  = array;

        //replace internal array with a larger empty version
        array = (Node<K, V>[]) new Node[newCapacity];
        size = 0;

        // copy the old data into new array
        for (int i = 0; i < oldArray.length; i++) {
            for (Node<K,V> node = oldArray[i]; node != null; node = node.next){
                put(node.key, node.value);
            }
        }
    }

    /**
     * How do we add an element to the hash table?
     *   - change either the front node or the next field of a node in the list.
     *   - must make sure to avoid duplicates.
     *   - adds an element to the hash table, if not already there.
     * */
    @Override
    public V put(K key, V value) {
        //avoid duplicates
        if(!containsKey(key)){
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            //generate index for front of list
            int index   = hash(key);

            // add to front of linked list
            array[index] = new Node<>(key, value, array[index]);
            size++;
        }
        return value;
    }


    /**
     * How do we remove an element from the hash table?
     *   - change the front reference or the next reference of the previous node.
     *   -removes the given value if it is in the set.
     * */
    @Override
    public V remove(K key) {
        //get bucket index
        int index = hash(key);

        V value = null;

        //go to front node
        Node<K,V> front = array[index];

        if (front != null){
            //remove at front of linked list
            if(front.key.equals(key)){
                value        = front.value;
                array[index] = array[index].next;
                size--;
            }else{
                //check the rest of the list
                for(Node<K,V> node = front; node.next != null; node = node.next){
                    if(node.next.key.equals(key)){
                        value     = node.next.value;
                        node.next = node.next.next;
                        size--;
                    }
                }
            }// remove using next reference
        }
        return value;
    }

    //returns the number of elements in the set
    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        boolean isAtFront = true;
        if (!isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                for (Node<K, V> node = array[i]; node != null; node = node.next){
                    if (!isAtFront) {
                        result.append(", ");
                    }
                    result.append(node.key).append("=").append(node.value);
                    isAtFront = false;
                }
            }
        }
        return result + "}";
    }


    /**
     * represents a single entry in a linked chain
     * stored at one index location.
     */
    private static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value){
            this.key    = key;
            this.value  = value;
        }

        Node(K key, V value, Node<K, V> next){
            this.key    = key;
            this.value  = value;
            this.next   = next;
        }

    }
}
