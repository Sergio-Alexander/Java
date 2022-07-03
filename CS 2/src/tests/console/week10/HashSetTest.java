package tests.console.week10;
import utils.Set;
import utils.HashSet;

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

        System.out.println("====================  A  D   D   ======================");
        //test your add method
        System.out.println(set);
        set.add("Tim");
        System.out.println(set);
        set.add("Bob");
        System.out.println(set);

        System.out.println("====================  S  I Z  E  ======================");
        // test for size
        System.out.println("Size of container: " + set.size());
        set.add("Bart");
        System.out.println(set);
        set.add("Bill");
        System.out.println(set);
        System.out.println("Size of container: " + set.size());

        System.out.println("====================  R E M O V E  ======================");
        // test our "remove" method
        System.out.println(set);
        System.out.println("Removing Bob");
        set.remove("Bob");
        System.out.println(set);
        System.out.println("Size of container: " + set.size());

        System.out.println("====================  C O N T A I N S  ======================");
        //test for our "contains" method
        System.out.println("Search for Bart: \t" + set.contains("Bart"));
        System.out.println("Search for Bob: \t" + set.contains("Bob"));


        System.out.println("====================  C L E A R  ======================");
        // test for the "clear" method
        set.clear();
        System.out.println(set);
        System.out.println("Size of container: " + set.size());

        System.out.println("====================  I S   E M P T Y  ======================");
        // test for the "isEmpty" method
        System.out.println("Is the set empty? " + set.isEmpty());

    }
}



