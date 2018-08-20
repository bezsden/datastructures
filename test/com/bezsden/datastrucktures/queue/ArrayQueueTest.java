package com.bezsden.datastrucktures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {


        public static void main(String[] args) {
            Queue queue = new ArrayQueue();
            queue.enqueue("A");
            queue.enqueue("B");
            queue.enqueue("C");

            System.out.println(queue.dequeue());// A
            System.out.println(queue.size());// 2

            queue.enqueue("D");

            System.out.println(queue.size());// 3
            System.out.println(queue.dequeue());// B
        }
    }