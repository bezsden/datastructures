package com.bezsden.datastrucktures.list;

public class ArrayList implements List {
    private int size; // 0
    private Object[] array = new Object[5];


    private void increaseArray(Object[] array) {
        if (size == array.length) {
            int newSize = array.length * 3 / 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
        }
    }

    @Override
    public void add(Object value) {
        increaseArray(array);
        array[size] = value;
        size++;


    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 && index > size ) {
            throw
                    new IndexOutOfBoundsException();
        }
        increaseArray(array);
        //          A B C
        // 0 - size 0 1 2 , size 3
        // 1 add D



        System.arraycopy(array, index, array, index + 1, array.length-index-1);
        array[index] = value;
        size++;

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }
}