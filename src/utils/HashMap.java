package utils;

public class HashMap <K, V> implements Map <K, V>{

    private static final double MAX_LOAD_FACTOR = 0.75;
    private Node<K, V> [] array;
    private int size;

    public HashMap(){
        array = new Node[10] ;
        size = 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;

    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);

        for(Node node = array[index]; node != null; node = node.next){
            if(node.key == key){
                return true;
            }
        }

        return false;       // NOT FOUND
    }

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

    private void rehash(){
        Node[] oldArray  = array;

        //replace internal array with a larger empty version
        array = new Node[2 * oldArray.length];
        size = 0;

        // re-add the old data into new array
        for (int i = 0; i < oldArray.length; i++) {
            for (Node node = oldArray[i]; node != null; node = node.next){
                put((K)node.key, (V)node.value);
            }
        }
    }

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
            array[index] = new Node(key, value, array[index]);
            size++;
        }
        return value;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);

        V value = null;

        //go to front node
        Node front = array[index];

        if (front != null){
            //remove at front of linked list
            if(front.key == key){
                value = array[index].value;
                array[index] = array[index].next;
                size--;
            }else{
                //check the rest of the list
                for(Node node = front; node.next != null; node = node.next){
                    if(node.next.key == key){
                        value = array[index].value;
                        node.next = node.next.next;
                        size--;
                    }
                }
            }// remove using next reference
        }
        return value;
    }

    @Override
    public int size() {
        return 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        boolean isAtFront = true;
        if (!isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                for (Node node = array[i]; node != null; node = node.next){
                    if (!isAtFront) {
                        result.append(", ");
                    }
                    result.append(node.key + " " + node.value + " ");
                    isAtFront = false;
                }
            }
        }
        return result + "]";
    }


    static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
