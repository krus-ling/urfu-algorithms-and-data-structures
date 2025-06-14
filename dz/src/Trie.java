import java.util.HashMap;
import java.util.Map;

// Класс для узла trie (бора)
class TrieNode {

    // Мапа для хранения потомков: символ -> узел
    Map<Character, TrieNode> children;

    // Признак конца слова
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}


// Основной класс бора
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode(); // Корень дерева
    }

    // Метод для вставки слова в бор
    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            // Если нет пути по символу c, то создаем узел
            current.children.putIfAbsent(c, new TrieNode());
            // Переход к следующему узлу
            current = current.children.get(c);
        }

        // Помечаем конец слова
        current.endOfWord = true;
    }

    // Метод для поиска слова в боре
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            // Если символ отсутствует — слово не найдено
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        // Возвращаем true, если узел помечен как конец слова
        return current.endOfWord;
    }

    // Метод для проверки наличия префикса
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true; // Префикс найден
    }


    // Пример:
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("appl"));    // false
        System.out.println(trie.startsWith("ban"));      // true
        System.out.println(trie.startsWith("bat"));      // false
    }
}
