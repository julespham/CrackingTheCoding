package com.julespham.ctci.stacks_and_queues;

import java.util.EmptyStackException;
import java.util.Stack;

class SortStack {
    private Stack<Integer> sortedStack; 

    public SortStack() {
        sortedStack = new Stack<>();
    }

    /**
    * Pushes a new value onto the sorted Stack
     */
    public void push(int element) {
        Stack<Integer> tempStack = new Stack<>();
        while (!sortedStack.empty() && element > sortedStack.peek()) {
            tempStack.push(sortedStack.pop());
        }
        sortedStack.push(element);
        while(!tempStack.empty()) {
            sortedStack.push(tempStack.pop());
        }
    }
    /**
     * Pops the minimum element off the stack
     */
    public int pop() throws EmptyStackException {
        return sortedStack.pop();
    }  

    /** Returns the value on the top off the stack */
    public int peek() {
        return sortedStack.peek();
    }

    /** Determines if the stack is empty. */
    public boolean isEmpty() {
        return sortedStack.empty();
    }
}