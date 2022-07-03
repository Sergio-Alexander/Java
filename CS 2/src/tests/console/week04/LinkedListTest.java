package tests.console.week04;

public class LinkedListTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t M Y   L I N K E D   L I S T ");
        System.out.println(" \t \t T E S T   P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        java.util.LinkedList<String> list = new java.util.LinkedList<String>();
        list.add("Tom");
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        list.add("Tim");
        list.add(3, "Ken");
        System.out.println(list.size());
        System.out.println(list);
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("Item Removed : " + list.remove("John"));
        System.out.println("Item Removed : " + list.remove("Henry"));
        System.out.println(list.size());
        System.out.println(list);
    }

    public static void myVersionTest(){}

    public static void main(String[] args) {
        intro();
        myVersionTest();
    }

}
