import java.util.Arrays;
import java.util.EmptyStackException;

/* 
[3,4,5,10,11,23,34,40,50]
add(5, 0)
stack 1 position = [0,n/3]
stack 2 position = [n/3,2n/3]
stack 3 = [2n/3, n]

[null,4,5,10,11,23,34,40,50]
[5, 4, null, null, null, null, null, null]
add(5, 0)
*/


public class Multistack {
    int[] data;
    int capacity;
    int[] stackSizes;


    public Multistack(int capacity, int numStacks) {
        this.capacity = capacity;
        stackSizes = new int[numStacks];
        data = new int[capacity*numStacks];

    }

    //
    public boolean push(int stack, int item){
        if(stackSizes[stack] == capacity) {
            return false;
        }
        data[getTopIndex(stack)+1] = item;
        stackSizes[stack]++;
        return true;
    }

    public int peek(int stack) throws EmptyStackException{
        return data[getTopIndex(stack)];
    }

    private int getTopIndex(int stack) {
        return capacity * stack + stackSizes[stack] - 1;
    }

    public int pop(int stack) throws EmptyStackException{
        if (stackSizes[stack] == 0) {
            return 0;
        }
        int topIndex = getTopIndex(stack);
        int value = data[topIndex];
        data[topIndex] = 0;
        stackSizes[stack]--;
        return value;
    }

    public void print() {
        Arrays.stream(data).forEach(System.out::println);
    }
    
}