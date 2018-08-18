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
    private void bounds (int index){
        if (index < 0 || index > size-1) {
            throw
                    new IndexOutOfBoundsException();
        }
    }
    @Override
    public void add(Object value) {
        increaseArray(array);
        array[size] = value;
        size++; // has size then increases it, ++size  - increases first then shows increased.


    }

    @Override
    public void add(Object value, int index) {
        // everywhere size-1, here size
        if (index < 0 || index > size) {
            throw
                    new IndexOutOfBoundsException();
        }
        increaseArray(array);
        // A B C
        // 0 1 2 , size 3
        // A in 0 -> leave; B,C -> 2,3; D add to 1;
        // B,C  insert into 2, length 2, (size - index) or (array.length-index)
        // A B C D E, 5 -> insert E 2 -> A B, + C D E - > 2+1, 5-2 (size-index) ;
        System.arraycopy(array, index, array, index + 1, array.length - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        bounds(index);
        //array[index] = null;
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
        System.out.println(array[array.length - 1] + " " + array.length + " " + size);
        return array;
    }
    // A B C D E F 6
    // 0 1 2 3 4 5
    // rem B 1, A is ok, b is null 1 , CDEF into 1, size 4 = array.length-index = 6-1=5-1=4, addjust -1 for index update
    // alternative is to copy cdef to 1, without nullification, what is with index 5 value?


    @Override
    public Object get(int index) {

        bounds(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        bounds(index);
        return array[index]=value;
    }

    @Override
    public void clear() {
        array=new Object[5];

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size-1; i++) {
            if (array[i]!=null) {
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size-1; i++) {
            if (array[i].equals(value)) {
                return true;
            }

        }
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