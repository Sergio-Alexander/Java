package tests.console.week01;

import utils.SinglyLinkedList;

public class SLLPrintTest {

    public static void main(String[] args) {
        // strings                  -> ["Tim", "Jim", "Sam", "Bob"]
        // integer precision        -> [7, 2, 4, 1]
        // floating point precision -> [2.3, 1.8, 7.6, 4.9]

        //Anything Type is String
        SinglyLinkedList<String>  list = new SinglyLinkedList<>();
        list.add("Tom");
        list.add("Jim");
        list.add("Sam");
        System.out.println(list);

        //Anything Type is now Integer
        SinglyLinkedList<Integer>  iList = new SinglyLinkedList<>();
        iList.add(7);
        iList.add(4);
        iList.add(2);
        System.out.println(iList);

        //Anything Type is now Double
        SinglyLinkedList<Double>  dList = new SinglyLinkedList<>();
        dList.add(2.3);
        dList.add(1.8);
        dList.add(7.6);
        System.out.println(dList);

    }
}