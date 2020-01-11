public class Main {
    
    public static void main(String... args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.print();
        System.out.println(minStack.min());
        minStack.push(5);
        minStack.push(1);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
    }


}