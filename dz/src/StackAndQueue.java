import java.util.Stack;

// Реализация очереди через 2 стека
public class StackAndQueue<T> {
    private final Stack<T> stack1; // Основной стек для вставки элементов
    private final Stack<T> stack2; // Вспомогательный стек для извлечения элементов

    public StackAndQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Добавление элемента в очередь (enqueue)
    public void enqueue(T item) {
        stack1.push(item); // Просто добавляем элемент в stack1
    }

    // Удаление элемента из очереди (dequeue)
    public T dequeue() {
        if (stack2.isEmpty()) { // Если stack2 пуст, то переносим в него элементы из stack1
            if (stack1.isEmpty()) {
                throw new RuntimeException("Очередь пуста. Невозможно выполнить dequeue");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Перенос элементов, чтобы инвертировать порядок
            }
        }

        return stack2.pop(); // Удаляем верхний элемент из stack2
    }

    // Проверка пуста ли очередь
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Получение размера очереди
    public int size() {
        return stack1.size() + stack2.size();
    }

    // Получение элемента в начале очереди без удаления (peek)
    public T peek() {
        if (stack2.isEmpty()) { // Если stack2 пуст, нужно преложить элементы
            if (stack1.isEmpty()) {
                throw new RuntimeException("Очередь пуста.");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek(); // Верхний элемент stack2 — начало очереди
    }
}
