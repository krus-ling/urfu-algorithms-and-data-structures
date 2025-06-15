public class LinkedList_7 {

    // Внутренний класс — узел списка
    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    // Метод добавления элемента в конец списка
    public void add(int value) {

        Node newNode = new Node(value); // создаем новый узел

        if (head == null) {
            head = newNode; // если список пустой, то этот элемент становится первым
        } else {
            Node current = head; // иначе проходим до конца списка и добавляем

            while (current.next != null) { // этот цикл идёт по всем узлам, пока не найдёт последний
                current = current.next; // идём к следующему
            }

            current.next = newNode; // добавляем в конец
        }
    }

    // Вывод всех элементов списка
    public void printList() {

        Node current = head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("null"); // конец списка
    }

    public static void main(String[] args) {

        LinkedList_7 list = new LinkedList_7();

        list.add(1);
        list.add(24);
        list.add(30);

        list.printList();
    }
}
