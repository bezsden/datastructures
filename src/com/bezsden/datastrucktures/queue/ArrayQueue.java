package com.bezsden.datastrucktures.queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayQueue implements Queue,Iterable {
    private final static int INITIAL_CAPACITY = 2;

    Object[] array;
    int size;

    public ArrayQueue() {
        array = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void enqueue(Object value) {
        if (array.length == size) {
            Object[] newArray = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[size] = value;
        size++;
    }

    @Override
    public Object dequeue() {
        Object result = array[0];
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

     // iterable methods
    @Override
    public Iterator iterator() {
        return new ArrayQueueItarator();    }
//
//    @Override
//    public void forEach(Consumer action) {
//
//    }
//
//    @Override
//    public Spliterator spliterator() {
//        return null;
//    }
    // class iterator
    class ArrayQueueItarator implements Iterator{

        private int index;

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public Object next() {
            Object result = new Object();
            result=array[index];
            index++;
            return result;
        }
    }
}