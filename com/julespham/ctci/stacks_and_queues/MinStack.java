package com.julespham.stacks_and_queues;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    Stack<Integer> data;
    Stack<Integer> history;

    public MinStack() {
        data = new Stack<>();
        history = new Stack<>();
    }

    public void push(int item) {
        data.push(item);
        if (history.size() == 0 || item <= history.peek()) {
            history.push(item);
        }
    }

    public int min() throws EmptyStackException {
        return history.peek();
    }

    public int pop() throws EmptyStackException {
        int value = data.pop();
        if (value == history.peek()) {
            history.pop();
        }
        return value;
    }
}