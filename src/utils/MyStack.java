package utils;
import java.util.EmptyStackException;
/*****************************************************************
 * This class MyStack implements a LIFO data structure using
 * Linked Nodes.
 *****************************************************************/

public class MyStack <E> extends utils.ArrayList<E> {
    int size;
    Node<E> first;
    Node<E> last;

    public MyStack(){
        first = null;
        last  = null;
        size  = 0;
    }

    private E detach(){
        Node<E> oldLast = last;
        last            = last.next;
        E   removedItem = oldLast.data;
        oldLast.next    = null;     //for garbage collection
        return removedItem;
    }

    public E push(E item){
        Node<E> oldTop  = last;
        Node<E> newNode = new Node<>(item, oldTop);
        last            = newNode;
        if(isEmpty()){
            first = newNode;
        }
        size++;
        return last.data;
    }

    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E removedItem = detach();
        size--;
        return removedItem;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return last.data;
    }

    @Override
    public int  size() {
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
     }

    @Override
    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{
            ArrayList<E> list = new ArrayList<>(size);
            for(Node<E> node = last; node != null; node = node.next){
                list.add(0, node.data);
            }
            
            return list.toString();
        }
    }

    private static class Node<E>{ // generic node class
        //data fields (stores values)
        E       data;
        Node<E> next;
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
}
