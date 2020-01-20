package com.julespham.stacks_and_queues;

public class MyQueue {
    Stack stack1;
    Stack stack2;

    public MyQueue(int capacity) {
        stack1 = new Stack(capacity);
        stack2 = new Stack(capacity);
    }

    /**
     * Adds an element to the queue
     */
    public void enqueue(int element) {
        stack1.push(element);
    }

    /**
     * Removes an element from the queue 
     * @return an integer from the queue
     */
    public int dequeue() {
        if (isEmpty(stack2)) {
            while (!isEmpty(stack1)) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    /**
     * default isEmpty() method
     */
    public boolean isEmpty() {
        return stack2.size == 0;
    }

    /**
     * 
     * @param s
     * @return
     */
    public boolean isEmpty(Stack s) {
        return s.size == 0;
    }
    
}
