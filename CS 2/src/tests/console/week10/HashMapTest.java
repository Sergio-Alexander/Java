package tests.console.week10;

import utils.HashMap;
import utils.Map;

public class HashMapTest {

    public static void main(String[] args) {
        intro();

        //student mapping (names , ages)
        Map<String, Integer> map = new HashMap<>();

        // (add) "put" feature
        map.put("Will", 23);
        map.put("John", 32);
        map.put("George", 18);
        map.put("Jesse", 40);
        map.put("Will", 21);
        map.put("West", 15);
        map.put("Jorge", 36);
        map.put("Heller", 20);
        System.out.println(map);
        System.out.println();

        //this is the time that the rehash method may kick in
        System.out.println("Size = " + map.size());
        map.put("Martin", 19);
        map.put("May", 23);
        System.out.println("after adding two other values: ");
        System.out.println(map);
        System.out.println();

        //size feature
        System.out.println("Size = " + map.size());
        System.out.println();

        //remove feature
        map.remove("Jorge");
        System.out.print("removed Jorge: ");
        System.out.println(map);

        // size put feature
        System.out.println("Size after remove Jorge = " + map.size());
        map.put("Jorge", 10);
        System.out.println("add Jorge: " + map);

        System.out.println();

        // containsKey feature (basically search and find items)
        System.out.println("contains John? " + map.containsKey("John"));
        System.out.println("contains Nathan? " + map.containsKey("Nathan"));
        System.out.println();

        // isEmpty, clear and size feature
        System.out.println("isEmpty = " + map.isEmpty());
        System.out.println("Size = " + map.size());
        System.out.println();
        map.clear();
        System.out.println("Size after clear = " + map.size());
        System.out.println("isEmpty = " + map.isEmpty());
    }

    public static void intro() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t \t \t H A S H   M A P ");
        System.out.println(" \t \t \t T E S T   P R O G R A M");
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
    }
}
