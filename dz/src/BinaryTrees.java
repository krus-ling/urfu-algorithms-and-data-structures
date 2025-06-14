// Класс узла бинарного дерева
class Node {
    int value;        // Значение, хранящееся в узле
    Node left, right; // Ссылки на левого и правого потомков

    public Node(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}


// Класс для работы с бинарным деревом поиска
public class BinaryTrees {
    Node root; // Корень дерева

    /**
     * Метод для вставки нового значения в дерево
     * @param value значение, которое нужно вставить
     */
    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    /**
     * Рекурсивный метод вставки
     * @param current текущий узел, в который пытаемся вставить значение
     * @param value значение, которое вставляем
     * @return ссылка на текущий узел после вставки
     */
    private Node insertRecursively(Node current, int value) {
        // Если текущий узел пуст — создаем новый узел с нужным значением
        if (current == null) {
            return new Node(value);
        }

        // Если вставляемое значение <=, то идем в левое поддерево
        if (value < current.value) {
            current.left = insertRecursively(current.left, value);
        }

        // Иначе идем в правое поддерево
        else if (value > current.value) {
            current.right = insertRecursively(current.right, value);
        }

        return current; // Возвращаем текущий узел
    }

    /**
     * Метод для вывода дерева (инфиксный обход)
     * @param node узел, с которого начинаем обход
     */
    public void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);              // Сначала обходим левое поддерево
            System.out.println(node.value + " "); // Потом печатаем текущее значение
            printInorder(node.right);             // Затем обходим правое поддерево
        }
    }


    public static void main(String[] args) {

        BinaryTrees tree = new BinaryTrees();

        // Проверка
        tree.insert(50);
        tree.insert(30);
        tree.insert(700);
        tree.insert(-20);
        tree.insert(40);
        tree.insert(0);
        tree.insert(80);

        // Выводим отсортированные элементы дерева
        System.out.println("Сортировка по возрастанию");
        tree.printInorder(tree.root);
    }
}
