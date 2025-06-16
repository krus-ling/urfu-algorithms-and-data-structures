import java.util.HashMap;
import java.util.Map;

/**
 * Класс Bor_37 реализует структуру данных "бор",
 * предназначенную для хранения набора строк и эффективного поиска по ним.
 * Поддерживаются операции вставки слова, поиска полного слова и поиска по префиксу.
 */
public class Bor_37 {

    /**
     * Внутренний класс, представляющий узел дерева.
     * Каждый узел содержит:
     * - отображение символов к дочерним узлам
     * - флаг, указывающий, заканчивается ли на этом узле слово
     */
    private static class Node {
        Map<Character, Node> children = new HashMap<>(); // дочерние символы и соответствующие узлы
        boolean isEndOfWord = false; // флаг окончания слова
    }

    private final Node root = new Node(); // корень дерева

    /**
     * Вставляет слово в бор.
     * Если символов ещё нет в дереве, создаёт новые узлы.
     *
     * @param word слово для вставки
     */
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            // computeIfAbsent создаёт новый узел, если символ ещё не встречался
            node = node.children.computeIfAbsent(ch, _ -> new Node());
        }
        node.isEndOfWord = true; // помечаем конец слова
    }

    /**
     * Проверяет, содержится ли полное слово в боре.
     *
     * @param word слово для поиска
     * @return true, если слово полностью содержится в дереве, иначе false
     */
    public boolean search(String word) {
        Node node = findNode(word);
        // Если узел найден и он помечен как конец слова — возвращаем true
        return node != null && node.isEndOfWord;
    }

    /**
     * Проверяет, начинается ли какое-либо слово в боре с указанного префикса.
     *
     * @param prefix префикс для поиска
     * @return true, если есть хотя бы одно слово с таким префиксом
     */
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    /**
     * Вспомогательный метод, проходящий по дереву согласно переданной строке.
     * Используется для реализации методов search и startsWith.
     *
     * @param str строка (слово или префикс), по которой нужно пройтись по дереву
     * @return конечный узел, соответствующий последнему символу строки, либо null, если путь обрывается
     */
    private Node findNode(String str) {
        Node node = root;
        for (char ch : str.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return null; // если путь обрывается, возвращаем null
            }
        }
        return node;
    }

    /**
     * Пример использования структуры бор.
     * Демонстрирует вставку и поиск слов и префиксов.
     */
    public static void main(String[] args) {
        Bor_37 bor = new Bor_37();

        bor.insert("apple");
        System.out.println(bor.search("apple"));     // true — слово "apple" есть в боре
        System.out.println(bor.search("app"));       // false — "app" не завершён как слово
        System.out.println(bor.startsWith("app"));   // true — есть слово, начинающееся с "app"

        bor.insert("app");
        System.out.println(bor.search("app"));       // true — теперь "app" тоже вставлено как отдельное слово
    }
}
