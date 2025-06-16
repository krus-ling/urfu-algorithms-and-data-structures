public class BinarySearchTrees_24 {

    private static class TreeNode {
        int value;
        TreeNode left; // левый потомок
        TreeNode right; // правый потомок

        public TreeNode(int value) {
            this.value = value;
            this.left = null; // сначала потомков нет
            this.right = null;
        }
    }


    private TreeNode root; // корень дерева

    // метод вставки нового значения в дерево
    public void insert(int value) {

        root = insert(root, value); // запускаем рекурсивную вставку от корня

    }

    // вспомогательный метод: рекурсивная вставка
    private TreeNode insert(TreeNode current, int value) {

        // если узла нет – создаем его
        if (current == null) {
            return new TreeNode(value);
        }

        // если значение меньше текущего – идем влево
        if (value < current.value) {
            current.left = insert(current.left, value);
        } else if (value > current.value) {
            current.right = insert(current.right, value);
        }

        // возвращаем текущий узел (после вставки в поддерево)
        return current;
    }

    // Обход дерева (in-order)
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left); // сначала левое поддерево
            System.out.print(node.value + " "); // затем сам узел
            inOrderTraversal(node.right); // потом правое поддерево
        }
    }

    // обертка обхода дерева, вывод
    public void printTree() {
        System.out.print("Обход дерева (in-order): ");
        inOrderTraversal(root);
        System.out.println();
    }




    public static void main(String[] args) {

        BinarySearchTrees_24 tree = new BinarySearchTrees_24();

        // Вставка элементов в дерево
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.printTree();
    }
}
