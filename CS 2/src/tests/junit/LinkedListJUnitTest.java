package tests.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import coordinates.Point;
import utils.LinkedList;

public class LinkedListJUnitTest {

    //NOTE THIS METHOD REQUIRES THE "ADD-APPEND" METHOD TO BE IMPLEMENTED
    @Test
    void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("---------------- T  E  S  T   DEFAULT CONSTRUCTOR( ) ----------------");
        System.out.println("size BEFORE: " + list.size());

        assertEquals(0, list.size());
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Uranus"));
        assertTrue(list.add("Neptune"));
        assertTrue(list.add("Helios"));
        assertTrue(list.add("Cronus"));
        assertTrue(list.add("Aurora"));
        assertEquals(10, list.size());

        System.out.println("---------------- T  E  S  T   EXPANDING CAPACITY ----------------");
        assertTrue(list.add("Aurelius"));
        assertTrue(list.add("Argon"));
        assertEquals(12, list.size());

        System.out.println(list);
        System.out.println("size AFTER: " + list.size());
        System.out.println();

    }


    @Test
    void testAddE() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("---------------- T  E  S  T   ADD(E item) ----------------");
        assertTrue(list.add("Mercury"));
        assertEquals(1, list.size());
        assertTrue(list.add("Venus"));
        assertEquals(2, list.size());
        assertTrue(list.add("Mars"));
        assertEquals(3, list.size());
        assertTrue(list.add("Jupiter"));
        assertEquals(4, list.size());
        assertTrue(list.add("Saturn"));
        assertEquals(5, list.size());
        assertTrue(list.add("Neptune"));
        assertEquals(6, list.size());
        assertTrue(list.add("Helios"));
        assertEquals(7, list.size());

        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();
    }


    @Test
    void testAddIntE() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("---------------- T  E  S  T   ADD(int index, E item) -------------");
        list.add(0,"Mercury");
        assertEquals(1, list.size());

        // ----------  ADD AT BACK  ---------------
        list.add(1,"Venus");
        assertEquals(2, list.size());

        list.add(2, "Mars");
        assertEquals(3, list.size());

        System.out.println(list);
        System.out.println();

        System.out.println("--------- ADD IN FRONT ---------");
        list.add(0, "Helios");
        list.add(0, "Cronus");
        list.add(0, "Aurora");

        System.out.println(list);
        System.out.println();

        assertEquals("Aurora" , list.get(0));
        assertEquals("Cronus" , list.get(1));
        assertEquals("Helios" , list.get(2));

        System.out.println();

        System.out.println("--------- ADD IN MIDDLE ---------");

        list.add(3, "Saturn");
        assertEquals("Saturn"  , list.get(3));

        System.out.println(list);

        list.add(3, "Jupiter");
        assertEquals("Jupiter", list.get(3));

        System.out.println(list);

        System.out.println();
        System.out.println("--------- ADD AT END ---------");

        list.add(list.size(), "Neptune");
        assertEquals("Neptune", list.get(list.size() - 1));

        System.out.println(list);
        System.out.println("size: " + list.size());

        list.add(list.size(), "Uranus");
        assertEquals("Uranus", list.get(list.size() - 1));

        System.out.println(list);
        System.out.println("size: " + list.size());

        int sizeA = -(list.size() + 1);
        int sizeB = list.size() + 2;

        //TEST INDEX OUT OF BOUNDS
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(sizeA, "Mars"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(sizeB, "Mars"));
        System.out.println();

    }

    //NOTE THIS METHOD REQUIRES THE "GET" METHOD TO BE IMPLEMENTED
    @Test
    void testClear() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("---------------- T  E  S  T   CLEAR( ) ----------------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Uranus"));
        assertTrue(list.add("Neptune"));

        System.out.println(list);
        System.out.println("size BEFORE: " + list.size());

        assertEquals(7, list.size());
        list.clear();
        assertEquals(0, list.size());

        System.out.println("size AFTER: " + list.size());
        System.out.println();

        //TEST IF EMPTY
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        System.out.println();

    }


    @Test
    void testContains() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("------------- T  E  S  T  CONTAINS(String item) -------------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Uranus"));
        assertTrue(list.add("Neptune"));
        assertEquals(7, list.size());

        printIndex(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println("has Neptune? " + list.contains("Neptune"));
        System.out.println("has Saturn? " + list.contains("Saturn"));
        System.out.println("has Helios? " + list.contains("Helios"));

        assertTrue(list.contains("Neptune"));
        assertTrue(list.contains("Saturn"));
        assertFalse(list.contains("Helios"));
        System.out.println();

        System.out.println("---------------- T  E  S  T   CONTAINS(Point item) ----------------");

        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(6, 5));
        points.add(new Point(3, 7));
        points.add(new Point(7, 9));
        points.add(new Point(9, 4));
        points.add(new Point(2, 5));
        points.add(new Point(5, 6));
        points.add(new Point(1, 8));

        printIndex(list.size());
        System.out.println(points);
        System.out.println();

        //SEARCH AND FIND
        assertTrue(points.contains(new Point(6, 5)));
        assertTrue(points.contains(new Point(9, 4)));
        assertTrue(points.contains(new Point(1, 8)));
        assertFalse(points.contains(new Point(1, 2)));

        // PRINT SEARCH
        System.out.println("contains (6, 5)? " + points.contains(new Point(6, 5)));
        System.out.println("contains (9, 4)? " + points.contains(new Point(9, 4)));
        System.out.println("contains (1, 8)? " + points.contains(new Point(1, 8)));
        System.out.println("contains (1, 2)? " + points.contains(new Point(1, 2)));
        System.out.println("contains (9, 3)? " + points.contains(new Point(9, 3)));
        System.out.println();

    }


    @Test
    void testGet() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("---------------- T  E  S  T    GET( ) ----------------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Uranus"));
        assertTrue(list.add("Neptune"));

        assertEquals("Mercury", list.get(0));
        assertEquals("Jupiter", list.get(3));
        assertEquals("Neptune", list.get(6));

        System.out.println(list);
        System.out.println("who is at 0? " + list.get(0));
        System.out.println("who is at 3? " + list.get(3));
        System.out.println("who is at 6? " + list.get(6));

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-(list.size() + 1)));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 2));
        System.out.println();

    }


    @Test
    void testIndexOf() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("---------------- T  E  S  T   INDEX OF(String item) ----------------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Uranus"));
        assertTrue(list.add("Neptune"));

        assertEquals(0, list.indexOf("Mercury"));
        assertEquals(3, list.indexOf("Jupiter"));
        assertEquals(6, list.indexOf("Neptune"));
        assertEquals(-1, list.indexOf("Helios"));
        assertEquals(-1, list.indexOf("Aurora"));

        printIndex(list.size());
        System.out.println(list);
        System.out.println();

        System.out.println("location of Mercury: " + list.indexOf("Mercury"));
        System.out.println("location of Jupiter: " + list.indexOf("Jupiter"));
        System.out.println("location of Neptune: " + list.indexOf("Neptune"));
        System.out.println();

        System.out.println(list);
        System.out.println();

        System.out.println("---------------- T  E  S  T   INDEX OF(Point item) ----------------");

        LinkedList<Point> points = new LinkedList<>();

        points.add(new Point(6, 5));
        points.add(new Point(3, 7));
        points.add(new Point(7, 9));
        points.add(new Point(9, 4));
        points.add(new Point(2, 5));
        points.add(new Point(5, 6));
        points.add(new Point(1, 8));

        printIndex(points.size());
        System.out.println(points);
        System.out.println();
        System.out.println();

        assertEquals(0, points.indexOf(new Point(6, 5)));
        assertEquals(3, points.indexOf(new Point(9, 4)));
        assertEquals(6, points.indexOf(new Point(1, 8)));
        assertEquals(-1, points.indexOf(new Point(1, 2)));


        System.out.println("location of (6, 5) " + points.indexOf(new Point(6, 5)));
        System.out.println("location of (9, 4) " + points.indexOf(new Point(9, 4)));
        System.out.println("location of (1, 8) " + points.indexOf(new Point(1, 8)));
        System.out.println("location of (1, 2) " + points.indexOf(new Point(1, 2)));
        System.out.println("location of (9, 3) " + points.indexOf(new Point(9, 3)));
        System.out.println();

    }


    @Test
    void testIsEmpty() {
        LinkedList<String> list = new LinkedList<>();

        assertTrue(list.isEmpty());

        System.out.println();
        System.out.println("-------------- T  E  S  T   IS EMPTY() --------------");
        list.add(0,"Mercury");
        assertEquals(1, list.size());
        list.add(1,"Venus");
        assertEquals(2, list.size());
        list.add(2,"Saturn");
        assertEquals(3, list.size());
        list.add(3,"Jupiter");
        assertEquals(4, list.size());
        list.add(4,"Neptune");
        assertEquals(5, list.size());
        list.add(5,"Uranus");
        assertEquals(6, list.size());

        assertFalse(list.isEmpty());

        System.out.println();
        System.out.println(list);
        System.out.println();
        System.out.printf("size before clearing: %d \n", list.size());

        System.out.println();
        System.out.println("------------ C  L  E  A  R  ------------");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list);
            System.out.println(list.remove(0));
            System.out.println();
        }

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        System.out.println(list);
        System.out.println();

    }


    @Test
    void testRemoveE(){
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("---------------- T  E  S  T   REMOVE(String item) ----------------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Gregorian"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Valerian"));
        assertTrue(list.add("Julian"));

        System.out.println();
        System.out.println(list);
        System.out.println("LIST SIZE: " + list.size());

        assertEquals(7, list.size());

        //---------------- REMOVE FROM MIDDLE ----------------
        assertTrue(list.remove("Gregorian"));
        assertEquals(6, list.size());
        assertTrue(list.remove("Mars"));
        assertEquals(5, list.size());
        assertTrue(list.remove("Valerian"));
        assertEquals(4, list.size());
        assertFalse(list.remove("Gregorian"));
        assertEquals(4, list.size());

        //---------------- REMOVE FROM FRONT ----------------
        assertTrue(list.remove("Mercury"));
        assertEquals(3, list.size());


        //---------------- REMOVE FROM BACK ----------------
        assertTrue(list.remove("Julian"));
        assertEquals(2, list.size());

        //---------------- REMOVE ITEM NOT IN LIST
        assertFalse(list.remove("Callisto"));
        assertEquals(2, list.size());

        System.out.println();
        System.out.println(list);
        System.out.println("LIST SIZE: " + list.size());
        System.out.println();

        System.out.println("---------------- T  E  S  T   REMOVE(Point item) ----------------");

        LinkedList<Point> points = new LinkedList<>();

        assertEquals(0, points.size());

        points.add(new Point(6, 5));
        points.add(new Point(8, 6));
        points.add(new Point(3, 7));
        points.add(new Point(7, 9));
        points.add(new Point(2, 5));
        points.add(new Point(9, 4));
        points.add(new Point(5, 6));
        points.add(new Point(1, 8));
        points.add(new Point(4, 8));

        System.out.println();
        System.out.println(points);
        System.out.println("LIST SIZE: " + points.size());
        System.out.println();

        assertTrue(points.remove(new Point(6, 5)));
        assertTrue(points.remove(new Point(5, 6)));
        assertTrue(points.remove(new Point(4, 8)));

        System.out.println();
        System.out.println(points);
        System.out.println("LIST SIZE: " + points.size());
        System.out.println();

    }


    @Test
    void testRemoveInt() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("----------------  T  E  S  T   REMOVE(int index) ----------------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Gregorian"));
        assertTrue(list.add("Valerian"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));


        //---------------- REMOVE FROM MIDDLE ----------------
        System.out.println(list);
        assertEquals(7, list.size());
        System.out.println("size BEFORE: " + list.size());

        assertEquals("Gregorian", list.remove(3));
        assertEquals("Jupiter", list.remove(4));

        assertEquals(5, list.size());
        System.out.println();
        System.out.println( list);
        System.out.println("size AFTER: " + list.size());


        //---------------- ADD TO FRONT ----------------
        list.add(0, "Aurelius");
        list.add(0, "Artemis");
        list.add(0, "Barnabas");
        assertEquals(8, list.size());


        //---------------- REMOVE FROM FRONT ----------------
        assertEquals("Barnabas", list.remove(0));
        assertEquals(7, list.size());
        assertEquals("Artemis", list.remove(0));
        assertEquals(6, list.size());
        assertEquals("Aurelius", list.remove(0));
        assertEquals(5, list.size());


        //---------------- ADD TO BACK ----------------
        assertTrue(list.add("Cronus"));
        assertTrue(list.add("Jupiter"));
        assertEquals(7, list.size());

        System.out.println();
        System.out.println(list);
        System.out.println("size BEFORE: " + list.size());

        //---------------- REMOVE FROM BACK ----------------
        assertEquals("Jupiter", list.remove(list.size() - 1));
        assertEquals(6, list.size());
        assertEquals("Cronus", list.remove(list.size() - 1));
        assertEquals(5, list.size());

        System.out.println();
        System.out.println(list);
        System.out.println("size AFTER: " + list.size());

        System.out.println();
        System.out.println("<---------- P O I N T S   REMOVE(int index) ----------->");
        System.out.println();

        LinkedList<Point> points = new LinkedList<>();

        assertEquals(0, points.size());

        //------ THIS METHOD IS NORMALLY IMPLEMENTED BEFORE ADD-INSERT ------
        points.add(new Point(8, 6));
        points.add(new Point(3, 7));
        points.add(new Point(7, 9));
        points.add(new Point(2, 5));
        points.add(new Point(9, 4));
        points.add(new Point(5, 6));
        points.add(new Point(1, 8));
        assertEquals(7, points.size());

        System.out.println("LIST SIZE: " + points.size());

        System.out.println();
        System.out.println("<-------------- REMOVE POINT FROM FRONT -------------->");
        System.out.println();

        System.out.println(points);

        assertEquals(new Point(8, 6), points.remove(0));
        assertEquals(6, points.size());

        System.out.println();
        System.out.println(points);

        assertEquals(new Point(3, 7), points.remove(0));
        assertEquals(5, points.size());

        System.out.println();
        System.out.println(points);

        System.out.println();
        System.out.println("<-------------- REMOVE POINT FROM BACK -------------->");
        System.out.println();

        System.out.println(points);

        assertEquals(new Point(1, 8), points.remove(points.size() - 1));
        assertEquals(4, points.size());

        System.out.println();
        System.out.println(points);

        assertEquals(new Point(5, 6), points.remove(points.size() - 1));
        assertEquals(3, points.size());

        System.out.println();
        System.out.println(points);
        System.out.println();
        System.out.println("LIST SIZE: " + points.size());
        System.out.println();


        //Test FOR INDEX OUT OF BOUNDS
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-(list.size() + 1)));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size() + 2));
        assertThrows(IndexOutOfBoundsException.class, () -> points.remove(points.size()));

        System.out.println();
        System.out.println("TEST for throwing IndexOutOfBoundsException -> PASSED");

    }


    @Test
    void testSet() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());

        System.out.println("-------- T  E   S  T   SET(int index, String item) --------");
        assertTrue(list.add("Mercury"));
        assertTrue(list.add("Venus"));
        assertTrue(list.add("Mars"));
        assertTrue(list.add("Jupiter"));
        assertTrue(list.add("Saturn"));
        assertTrue(list.add("Uranus"));
        assertTrue(list.add("Neptune"));

        System.out.println();
        printIndex(list.size());
        System.out.println(list);

        System.out.println();
        System.out.println("<------------- S  E  T   L O C A T I O N   1 ----------->");
        assertEquals("Venus", list.set(1, "Helios"));
        printIndex(list.size());
        System.out.println(list);

        System.out.println();
        System.out.println("<------------- S  E  T    L O C A T I O N   3 ----------->");
        assertEquals("Jupiter", list.set(3, "Aurelius"));
        printIndex(list.size());
        System.out.println(list);

        System.out.println();
        System.out.println("<------------- S  E  T    F R O N T ----------->");
        assertEquals("Mercury", list.set(0, "Aurora"));
        printIndex(list.size());
        System.out.println(list);

        System.out.println();
        System.out.println("<------------- S  E  T    B A C K ----------->");
        assertEquals("Neptune", list.set(list.size() - 1, "Jupiter"));
        printIndex(list.size());
        System.out.println(list);

        System.out.println();
        System.out.println("<---------- T E S T   SET(int index, Point item) ----------->");
        System.out.println();

        LinkedList<Point> points = new LinkedList<>();

        assertEquals(0, points.size());

        points.add(new Point(2, 5));
        points.add(new Point(8, 6));
        points.add(new Point(3, 7));
        points.add(new Point(4, 2));
        points.add(new Point(1, 8));
        assertEquals(5, points.size());

        System.out.println("LIST SIZE: " + points.size());

        System.out.println();
        System.out.println("<-------------- SET AT FRONT -------------->");
        System.out.println();

        System.out.println(points);

        assertEquals(new Point(2, 5), points.set(0, new Point(1, 1)));
        assertEquals(5, points.size());

        System.out.println();
        System.out.println(points);

        assertEquals(new Point(1, 1), points.set(0, new Point(3, 3)));
        assertEquals(5, points.size());

        System.out.println();
        System.out.println(points);

        System.out.println();
        System.out.println("<-------------- SET AT BACK -------------->");
        System.out.println();

        System.out.println(points);

        assertEquals(new Point(1, 8), points.set(points.size() - 1, new Point(2, 5)));
        assertEquals(5, points.size());

        System.out.println();
        System.out.println(points);

        assertEquals(new Point(2, 5), points.set(points.size() - 1, new Point(8, 3)));
        assertEquals(5, points.size());

        System.out.println();
        System.out.println(points);
        System.out.println();
        System.out.println("LIST SIZE: " + points.size());
        System.out.println();


        //TEST FOR INDEX OUT OF BOUNDS.
        int sizeA = -(list.size() + 1);
        int sizeB = list.size();
        int sizeC = list.size() + 2;
        int sizeD = points.size();
        Point p1  = new Point(1, 2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(sizeA, "Mars"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(sizeB, "Mars"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(sizeC + 2, "Mars"));
        assertThrows(IndexOutOfBoundsException.class, () -> points.set(sizeD, p1));
        System.out.println();

    }


    @Test
    void testSize() {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("---------------- T  E  S  T     S I Z E () ----------------");
        assertEquals(0, list.size());
        assertTrue(list.add("Mercury"));
        assertEquals(1, list.size());
        assertTrue(list.add("Venus"));
        assertEquals(2, list.size());
        assertTrue(list.add("Mars"));
        assertEquals(3, list.size());
        assertTrue(list.add("Jupiter"));
        assertEquals(4, list.size());
        assertTrue(list.add("Saturn"));
        assertEquals(5, list.size());

        System.out.println(list);
        System.out.println("size end: " + list.size());

        System.out.println();
    }

    // NON-TEST : PRINTS INDEX WITH SPACING
    static void printIndex(int size){
        System.out.print("     0" );
        for (int i = 1; i < size; i++)
            System.out.print("       " + i);
        System.out.println();
    }

}

