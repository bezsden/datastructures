package com.bezsden.datastrucktures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArrayListTest {
    private ArrayList arrayWithThreeElements = new ArrayList();

    @Before
    public void before() {
        arrayWithThreeElements.add("A");
        arrayWithThreeElements.add("B");
        arrayWithThreeElements.add("C");
        arrayWithThreeElements.add("D");
        arrayWithThreeElements.add("E");
        arrayWithThreeElements.add("F");
    }

    @Test
    public void testGetByIndex() {
        assertEquals(6, arrayWithThreeElements.size());

        assertEquals("A", arrayWithThreeElements.get(0));
        assertEquals("B", arrayWithThreeElements.get(1));
        assertEquals("C", arrayWithThreeElements.get(2));
    }

    @Test
    public void testSize() {
        assertEquals(3, arrayWithThreeElements.size());
    }


    @Test
    public void testAddIndex() {
        // A B C D E F
        // 0 1 2 3 4 5 6 7 8
        // A D B C D E F      D1
        // A D E B C D E F    E2
        // A D E B C D E F A  A8
        assertEquals(6, arrayWithThreeElements.size());
       arrayWithThreeElements.add("D",1);
        assertEquals(7, arrayWithThreeElements.size());
        assertEquals("A", arrayWithThreeElements.get(0));
        assertEquals("D", arrayWithThreeElements.get(1));
        assertEquals("B", arrayWithThreeElements.get(2));
        arrayWithThreeElements.add("E",2);
        assertEquals(8, arrayWithThreeElements.size());
        assertEquals("D", arrayWithThreeElements.get(1));
        assertEquals("E", arrayWithThreeElements.get(2));
        assertEquals("B", arrayWithThreeElements.get(3));
        arrayWithThreeElements.add("X",0);
        assertEquals(9, arrayWithThreeElements.size());
        assertEquals("X", arrayWithThreeElements.get(0));
        assertEquals("A", arrayWithThreeElements.get(1));
         arrayWithThreeElements.add("A",9);
        assertEquals(10, arrayWithThreeElements.size());
        assertEquals("A", arrayWithThreeElements.get(9));
        assertEquals("A", arrayWithThreeElements.get(10));
    }
}