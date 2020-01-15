import java.util.EmptyStackException;
import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> data;
    LinkedList<Integer> history;

    public MinStack() {
        data = new LinkedList<>();
        history = new LinkedList<>();
    }

    public void push(int item) {
        data.add(item);
        if (history.peek() == null || history.peek() > item) {
            history.add(item);
        }
    }

    public int min() throws EmptyStackException {
        return history.peekLast();
    }

    public int pop() throws EmptyStackException {
        int value = data.removeLast();
        if (value == history.peekLast()) {
            history.remove();
        }
        return value;
    }

    public void print() {
        this.data.forEach(System.out::println);
    }


}