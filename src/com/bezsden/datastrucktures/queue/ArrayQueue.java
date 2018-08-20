package com.bezsden.datastrucktures.queue;

public class ArrayQueue implements Queue {
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
}