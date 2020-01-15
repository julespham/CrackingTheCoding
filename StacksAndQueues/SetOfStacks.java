package CodingProblems.Stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<Stack> stacks;
    int index;
    int capacity;

    public SetOfStacks(int capacity) {
        stacks = new ArrayList<>();
        this.capacity = capacity;
        this.index = 0;
    }

    /**
     * Push the element onto the current stack 
     * @param element
     */
    public void push(int element) {
        if (stacks.isEmpty() || fullCapacity()) {
            Stack stack = new Stack(capacity);
            stacks.add(stack);
        } 
        if (fullCapacity()) {
            index++;
        }
        getCurrentStack().push(element);
    }

    /**
     * Pop an element off the current stack 
     * @return int
     */
    public int pop() throws EmptyStackException{
        if (getCurrentStack().getSize() == 0 && index == 0 ) {
            return 0;
        }
        index = getCurrentStack().getSize() == 0 ||  getCurrentStack().getSize() == capacity ? index-1 : index;
        return getCurrentStack().pop();
    }

    /**
     * Pops the value off the specified stack
     * @param index
     */
    public int popAt(int index) {
        if (getCurrentStack(index).getSize() == 0) {
            return 0;
        }
            getCurrentStack(index).pop();
        }
    }

    public void clear() {
        stacks.stream().forEach(stack -> {
            while (stack.getSize() != 0) {
                stack.pop();
            }
        });
    }
    /**
     * Retrieves the current stack 
     * @return Stack object
     */
    private Stack getCurrentStack() {
        return stacks.get(this.index);
    }

    /**
     * Retrieves the current stack with the specified index
     * @param index
     * @return Stack object
     */
    private Stack getCurrentStack(int index) {
        return stacks.get(index);
    }

    /**
     * Checks if the current stack is at full capacity
     * @return
     */
    private boolean fullCapacity() {
        return stacks.get(index).getSize() == capacity;
    }

    public void print() {
        stacks.forEach(x-> x.printStack());
    }
}