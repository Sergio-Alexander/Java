package tests.console.week10;

import utils.HashMap;
import utils.Set;

public class HashMapTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t H A S H   S E T ");
        System.out.println(" \t \t T E S T   P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

    }

    public static void main(String[] args) {
        intro();

        HashMap<String, Integer> set = new HashMap<>();



        set.put("Bob", 5);
        set.put("Jim", 10);


        set.size();

        System.out.println(set);
    }
}
