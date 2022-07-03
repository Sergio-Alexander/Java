package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 *****************************************************************/

public class LinkedList<E> implements List<E>{

    //TODO : Complete Body with Data Fields, Methods and Classes

    Node<E> first;
    Node<E> last;
    int     size;

    public LinkedList(){
        first = null;
        last  = null;
        size  = 0;
    }

    public boolean add(E item){
        int oldSize = size;
        append(item);
        size++;
        return size == (oldSize + 1);
    }

    public void add(int index, E item){
        if (index == size){         // append to back
            append(item);
        }else{
            checkIndex(index);      // insert in middle and front
            insertBefore(index, item);
        }
        size++;
    }// might to change this

    public void append( E item){
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(oldLast, item);
        last            = newNode;

        if (isEmpty())
            first = newNode;                // add first item to list, when empty
        else{
            oldLast.next    = newNode;     // append to last node in list
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("Invalid");
        }
    }

    public boolean contains(E item){
        for(Node<E> node = first; node != null; node = node.next) {
            if (item.equals(node.data)) {
                return true;
            }
        }
        return false;
    }

    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    private E detach(int index){
        Node<E> target   = node(index);
        Node<E> previous = target.prev;
        Node<E> next     = target.next;
        E       data     = target.data;

        if(previous == null){
            first = next;
        }else{
            previous.next = next;
        }

        if(next == null){
            last = previous;
        }else{
            next.prev = previous;
        }
        return data;
    }

    public E get(int index){
        checkIndex(index);
        return node(index).data;
    }

    public int indexOf(E item){
        int index = 0;
        for(Node<E> node = first; node != null; node = node.next, index++){
            if (item.equals(node.data)) {
                return index;
            }
        }
        return -1;      // ITEM NOT FOUND
    }

    private void insertBefore(int index, E item){
      Node<E> target   = node(index);
      Node<E> previous = target.prev;
      Node<E> newNode  = new Node <E> (previous, item, target);
      target.prev       = newNode;

      if(previous == null){
          first = newNode;
      }else{
          previous.next = newNode;
      }
    }

    public boolean isEmpty(){
        return size == 0;
    }
    private Node<E> node(int index){
       Node<E> current;

       if(index < size / 2){    // goto first half
           current = first;
            for (int i = 0; i < index; i++)
                current = current.next;
       }else{                   // got to back half
           current = last;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
       }
        return current;
    }

    public E remove(int index){
        checkIndex(index); // checking validation of the index
        E deletedItem = detach(index);
        size--; // reducing size
        return deletedItem; //remove and return item at specified index
    }

    public boolean remove(E item){
        return contains(item) && item.equals(remove(indexOf(item)));
    }

    public E set(int index, E item){
        checkIndex(index); // checking validation
        Node<E> current = node(index);
        E oldData       = current.data;
        current.data    = item;
        return oldData; // replaces the item at the specified position
    }

    public int size(){
        return size;
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
        }
    }

    public  Iterator<E> iterator(){
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E>{
        Node<E> current;
        int     position;
        boolean isRemovable;
        public LinkedIterator(){
            current     = first;
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
            E currentItem = current.data;
            current       = current.next;
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
            LinkedList.this.remove(position - 1);
            isRemovable = false;
        }
    }

    private static class Node<E>{ // generic node class
        //data fields (stores values)
        E       data;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E data){
            this(prev, data, null);
        }

        public Node(Node<E> prev, E data, Node<E> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
