package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class MyQueue implements a FIFO data structure using
 * Linked Nodes.
 *****************************************************************/

public class MyQueue <E>{
    int size;
    Node<E> first;
    Node<E> last;

    public MyQueue(){
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

    private void append(E item){
        Node<E> newNode = new Node<>(item);
        if(isEmpty()){
            first = newNode;
        } else{
            last.next = newNode;
        }
        last = newNode;
    }

    private E detach(){
        Node<E> oldFirst = first;
        first            = first.next;
        E   removedItem  = oldFirst.data;
        oldFirst.next    = null;     //for garbage collection
        return removedItem;
    }

    public E remove(){
        if(isEmpty()){
           throw new NoSuchElementException();
        }
        E deletedItem = detach();
        size--;
        return deletedItem;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return first.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
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

    private static class Node<E>{ // generic node class
        //data fields (stores values)
        E       data;
        Node<E> next;
        public Node(E data){
            this(data, null);
        }

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
}
