package tests.console.week10;

import java.util.HashMap;

public class HashMapClientProgram {

    public static void main(String[] args) {

        //Mapping of Student-Key, Age-Value
        HashMap<String, Integer> map = new HashMap<>();

        //add feature
        map.put("Daniel", 19);
        map.put("Abel", 27);
        map.put("John", 20);
        map.put("Sarah", 22);
        map.put("Yao", 23);

        System.out.println();
        System.out.println("Size of Map = " + map.size());
        System.out.println();
        System.out.println();
        System.out.println(map);

        //search and find feature
        System.out.println("Contains Yao? " + map.containsKey("Yao"));

        //remove feature
        System.out.println();
        System.out.println();
        System.out.println(map);
        System.out.println();
        System.out.println("Remove John, Value = " + map.remove("John"));
        System.out.println(map);

    }
}