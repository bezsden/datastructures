package com.bezsden.datastrucktures.list;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E>  implements List<E>,Iterable<E>
{
    private int size; // 0
    private Object[] array = new Object[5];


    private void increaseArray(Object[] array) {
        if (size == array.length) {
            int newSize = array.length * 3 / 2+2; // +1 for object init 0-1 size
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
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }

    public void add(E value) {
        increaseArray(array);
        array[size] = value;
        size++; // has size then increases it, ++size  - increases first then shows increased.


    }

    @Override
    public void add(E value, int index) {
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
        System.arraycopy(array, index, array, index + 1, array.length - index-1 );
        array[index] = value;
        size++;
    }

    @Override
    public E remove(int index) {
        bounds(index);
        //array[index] = null;
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
        //System.out.println(array[array.length - 1] + " " + array.length + " " + size);
        return (E) array;
    }
    // A B C D E F 6
    // 0 1 2 3 4 5
    // rem B 1, A is ok, b is null 1 , CDEF into 1, size 4 = array.length-index = 6-1=5-1=4, addjust -1 for index update
    // alternative is to copy cdef to 1, without nullification, what is with index 5 value?


    @Override
    public E get(int index) {

        bounds(index);
        return (E) array[index];
    }

    @Override
    public E set(E value, int index) {
        bounds(index);
        return (E) (array[index]=value);
    }

    @Override
    public void clear() {
        array=new Object[5];
        size=0;

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
    public boolean contains(E value) {
        for (int i = 0; i < size-1; i++) {
            if (array[i].equals(value)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }

        }
        return -1;

    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size-1; i >=0; i--) {
            if (array[i].equals(value)) {
                return i;
            }

        }
        return -1;
     }

    @Override
    public String toString() {
        String arrayString=""+array[0];
        for (int i = 1; i < size; i++) {
             arrayString = arrayString + ", " + array[i];

        }
        arrayString="["+arrayString+"]";
        return arrayString ;

    }


    public class ArrayListIterator<E> implements Iterator<E> {
          int index;

         public boolean hasNext() {
            return index < size;
        }

         public E next() {
            E result = (E) array[index];
            index++;
            return result;
        }
    }


}