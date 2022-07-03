package tests.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import coordinates.Point;
import utils.ArrayList;
import utils.Iterator;
import utils.LinkedList;
import utils.List;

public class IteratorTest {

    @Test
    void testArrayIterator() {
        List<Point> list = new ArrayList<>();

        System.out.println("------ T  E  S  T    Array List Point Iterator  ------");
        list.add(0, new Point(7, 5));
        list.add(1, new Point(9, 4));
        list.add(2, new Point(5, 8));
        list.add(3, new Point(2, 5));
        list.add(4, new Point(6, 3));
        list.add(5, new Point(1, 8));
        list.add(6, new Point(4, 7));
        list.add(7, new Point(1, 6));
        System.out.println(list);

        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 8);

        if (!list.contains(point1) || !list.contains(point2)) {
            list.set(6, point1);
            list.set(2, point2);
        }

        assertEquals(point1, list.get(6));
        assertEquals(point2, list.get(2));
        System.out.println(list);
        System.out.println();

        Iterator<Point> itr = list.iterator();
        assertEquals(new Point(7, 5) ,  itr.next());
        assertEquals(new Point(9, 4) ,  itr.next());
        assertEquals(new Point(3, 8) ,  itr.next());
        assertEquals(new Point(2, 5) ,  itr.next());
        assertEquals(new Point(6, 3) ,  itr.next());
        assertEquals(new Point(1, 8) ,  itr.next());
        assertEquals(new Point(3, 4) ,  itr.next());
        assertEquals(new Point(1, 6) ,  itr.next());

    }


    @Test
    void testAIteratorLoop() {
        List<String> list = new ArrayList<>();

        System.out.println("------ T  E  S  T   Array Iterator Loop ------");
        list.add(0, "Mercury");
        list.add(1, "Venus");
        list.add(2, "Earth");
        list.add(3, "Mars");
        list.add(4, "Jupiter");
        list.add(5, "Saturn");
        list.add(6, "Neptune");
        list.add(7, "Uranus");
        System.out.println(list);

        Iterator<String> itr = list.iterator();
        int i = 0;
        String currentValue;
        boolean hasNextValue;

        while(itr.hasNext() && i < list.size()) {
            hasNextValue = itr.hasNext();
            currentValue = itr.next();

            System.out.print("hasNext: " + hasNextValue);
            System.out.println("\t next: " + currentValue);

            assertTrue(hasNextValue);
            assertEquals(list.get(i), currentValue);

            i++;
        }

        // At end of the list : No more elements
        assertFalse(itr.hasNext());

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();

}


    @Test
    void testAIteratorPoints() {
        List<Point> list = new ArrayList<>();

        System.out.println("------ T  E  S  T   Array Iterator Points ------");
        list.add(0, new Point(7, 5));
        list.add(1, new Point(9, 4));
        list.add(2, new Point(5, 8));
        list.add(3, new Point(2, 5));
        list.add(4, new Point(6, 3));
        list.add(5, new Point(1, 8));
        list.add(6, new Point(4, 7));
        list.add(7, new Point(1, 6));
        System.out.println(list);

        Iterator<Point> itr = list.iterator();
        int i = 0;
        Point currentValue;
        boolean hasNextValue;

        while(itr.hasNext() && i < list.size()) {
            hasNextValue = itr.hasNext();
            currentValue = itr.next();

            System.out.print("hasNext: " + hasNextValue);
            System.out.println("\t next: " + currentValue);

            assertTrue(hasNextValue);
            assertEquals(list.get(i), currentValue);

            i++;
        }

        // At end of the list : No more elements
        assertFalse(itr.hasNext());

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();

    }


    @Test
    void testLinkedIterator() {
        List<Point> list = new LinkedList<>();

        System.out.println("------- T  E  S  T   LinkedList Iterator() ------");
        list.add(0, new Point(7, 5));
        list.add(1, new Point(9, 4));
        list.add(2, new Point(5, 8));
        list.add(3, new Point(2, 5));
        list.add(4, new Point(6, 3));
        list.add(5, new Point(1, 8));
        list.add(6, new Point(4, 7));
        list.add(7, new Point(1, 6));
        System.out.println(list);

        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 8);

        if (!list.contains(point1) || !list.contains(point2)) {
            list.set(6, point1);
            list.set(2, point2);
        }

        assertEquals(point1, list.get(6));
        assertEquals(point2, list.get(2));
        System.out.println(list);
        System.out.println();

        Iterator<Point> itr = list.iterator();
        assertEquals(new Point(7, 5) ,  itr.next());
        assertEquals(new Point(9, 4) ,  itr.next());
        assertEquals(new Point(3, 8) ,  itr.next());
        assertEquals(new Point(2, 5) ,  itr.next());
        assertEquals(new Point(6, 3) ,  itr.next());
        assertEquals(new Point(1, 8) ,  itr.next());
        assertEquals(new Point(3, 4) ,  itr.next());
        assertEquals(new Point(1, 6) ,  itr.next());
    }


    @Test
    void testLLIteratorLoop() {
        List<String> list = new LinkedList<>();

        System.out.println("-------------- T  E  S  T   Linked Iterator Loop --------------");
        list.add(0, "Mercury");
        list.add(1, "Venus");
        list.add(2, "Earth");
        list.add(3, "Mars");
        list.add(4, "Jupiter");
        list.add(5, "Saturn");
        list.add(6, "Neptune");
        list.add(7, "Uranus");
        System.out.println(list);

        Iterator<String> itr = list.iterator();
        int i = 0;
        String currentValue;
        boolean hasNextValue;

        while(itr.hasNext() && i < list.size()) {
            hasNextValue = itr.hasNext();
            currentValue = itr.next();

            System.out.print("hasNext: " + hasNextValue);
            System.out.println("\t next: " + currentValue);

            assertTrue(hasNextValue);
            assertEquals(list.get(i), currentValue);

            i++;
        }

        // At end of the list : No more elements
        assertFalse(itr.hasNext());

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();
    }


    @Test
    void testLLIteratorPoints() {
        List<Point> list = new LinkedList<>();

        System.out.println("------ T  E  S  T   Linked Iterator Points ------");
        list.add(0, new Point(7, 5));
        list.add(1, new Point(9, 4));
        list.add(2, new Point(5, 8));
        list.add(3, new Point(2, 5));
        list.add(4, new Point(6, 3));
        list.add(5, new Point(1, 8));
        list.add(6, new Point(4, 7));
        list.add(7, new Point(1, 6));
        System.out.println(list);

        Iterator<Point> itr = list.iterator();
        int i = 0;
        Point currentValue;
        boolean hasNextValue;

        while(itr.hasNext() && i < list.size()) {
            hasNextValue = itr.hasNext();
            currentValue = itr.next();

            System.out.print("hasNext: " + hasNextValue);
            System.out.println("\t next: " + currentValue);

            assertTrue(hasNextValue);
            assertEquals(list.get(i), currentValue);

            i++;
        }

        // At end of the list : No more elements
        assertFalse(itr.hasNext());

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();

    }


}
