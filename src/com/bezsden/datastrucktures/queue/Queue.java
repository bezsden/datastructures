package com.bezsden.datastrucktures.queue;

public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    int size();
}