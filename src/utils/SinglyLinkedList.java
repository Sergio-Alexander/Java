package utils;

/**
 * This class is a generic class that can take any type in the "<>" placeholder
 *
 */

public class SinglyLinkedList<E> {

    Node<E> first;
    int     size;

    public SinglyLinkedList(){
        first = null;
        size  = 0;
    }
    public boolean add(E item){
        int oldSize = size;
        append(item);
        size++;
        return size == (oldSize + 1);
    }

    /**
     * This method add items to the back of list
     * @param item
     */

    public void add(int index, E item){
        if (index == size){         // append to back
            append(item);
        }else{
            checkIndex(index);      // insert in middle and front
            insertBefore(index, item);
            size++;
        }
    }

    private void append(E item){
        // find the last node in the list (index location).

        Node<E> newNode = new Node<>(item);

        if (isEmpty())
            first = newNode;            // add first item to list, when empty
        else{
            Node<E> oldLast = node(size - 1);
            oldLast.next    = newNode;     // append to last node in list
        }
    }


    private void checkIndex(int index){
        if(index < 0 || index >= size){ // if the index is less than or greater than the size, it will become invalid
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }

    private E detach(int index){//detaching the node at the specified index from list
        Node<E> target;
        if(index == 0){
            target = first;
            first  = target.next;
        }
        else{
            Node <E> nodeBefore = node(index - 1);
            target              = nodeBefore.next;
            nodeBefore.next     = target.next;
        }
        return target.data;
    }

    public E get(int index){
        checkIndex(index);
        return node(index).data; // returning the data at a specified position
    }

    private void insertBefore(int index, E item){
        checkIndex(index); // checking validation of the index

        Node<E> x = new Node<>(item); // declaring x
        if(index == 0 || first == null) { // if index is 0, x will be the first node
            x.next = first;
            first  = x;
        }
        else{
            Node<E> current = node(index - 1); // declaring current
            x.next          = current.next;
            current.next    = x;
        }//insert a node at a specified index
    }


    public boolean isEmpty(){
        return size == 0; // if size is empty, return 0
    }

    private Node<E> node(int index){
        Node<E> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;  // returning the address of the node at the given position in the list
    }

    public E remove(int index){
        checkIndex(index); // checking validation of the index
        E deletedItem = detach(index);
        size--; // reducing size
        return deletedItem; //remove and return item at specified index
    }

    public E set(int index, E item){
        checkIndex(index); // checking validation
        Node<E> current = node(index);
        E oldData       = current.data;
        current.data    = item;
        return oldData; // replaces the item at the specified position
    }

    public int size(){
        return size; // returning the value of the size
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{

            StringBuilder result = new StringBuilder("[" + first.data);

            for(Node<E> node = first.next; node != null; node = node.next){
                result.append(", ").append(node.data);
            }
            return result + "]";
        } // displaying contents to the list
    }


    /**
     *  This class is decoupled from the outer class Singly Linked List
     *  This is a class that will serve as storage for items in the list.
     */
    private static class Node<Sergio>{ // generic node class
        //data fields (stores values)
        Sergio       data;
        Node<Sergio> next;

        public Node(Sergio data){
            this(data, null);
        }

        public Node(Sergio data, Node<Sergio> next){
            this.data = data;
            this.next = next;
        }
    }
}