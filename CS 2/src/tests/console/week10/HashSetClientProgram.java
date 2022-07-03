package tests.console.week10;

import utils.HashSet;

public class HashSetClientProgram {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        // add feature
        set.add("John");
        set.add("Abel");
        set.add("Daniel");
        set.add("Yao");
        set.add("Sarah");

        System.out.println();
        System.out.println(set);
        System.out.println("Size of Set : " + set.size());
        System.out.println();

        //search and find feature
        System.out.println("Does it contain Abel? " + set.contains("Abel"));
        System.out.println();
        System.out.println();

        //remove feature
        System.out.println(set);
        System.out.println("Remove Daniel");
        set.remove("Daniel");
        System.out.println(set);
        System.out.println();

    }
}