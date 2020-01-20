package com.julespham.stacks_and_queues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    int[] data;
    int size;
    int capacity;
    
    public Stack(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void push(int item) {
        if (size != capacity) {
            data[size] = item;
            size++;   
        }
    }

    public int pop() throws EmptyStackException {
        size--;
        int value = data[size];
        data[size] = 0; 
        return value;
    }

    public int peek() throws EmptyStackException {
        return data[size];
    }

    public void print() {
        Arrays.stream(data).forEach(System.out::println);
    }

    public int getSize() {
        return this.size;
    }
}