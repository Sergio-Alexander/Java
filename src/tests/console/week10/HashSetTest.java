package tests.console.week10;
import utils.Set;
import utils.HashSet;

import java.util.Arrays;

public class HashSetTest {

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

        Set<String> set = new HashSet<>();

        set.add("Tim");
        set.add("Bob");

        set.remove("Bob");

        set.add("Bob");


        System.out.println(set);
    }
}



