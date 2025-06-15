import java.util.Stack;

public class StackAndQueue_9 {

    private final Stack<Integer> stackIn;
    private final Stack<Integer> stackOut;

    public StackAndQueue_9() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void enqueue(int value) {
        stackIn.push(value);
    }

    public int dequeue() {

        moveInToOut();

        if (stackOut.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stackOut.pop();
    }

    public int peek() {

        moveInToOut();

        if (stackOut.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stackOut.peek();
    }

    // Вспомогательный метод: перекладывает элементы из stackIn в stackOut
    // стек переворачивается
    public void moveInToOut() {

        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public static void main(String[] args) {

        StackAndQueue_9 queue = new StackAndQueue_9();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.peek()); // 3
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.dequeue()); // 4
        System.out.println(queue.isEmpty()); // true
    }
}
