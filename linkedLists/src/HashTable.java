import java.util.LinkedList;
import java.util.List;

public class HashTable {

    public static void main(String[] args) {

        /*
        Используем LinkedList, т.к.:
            1. Вставка в начало списка выполняется за O(1), за счет ссылок на следующие элементы;
            2. Итерирование через for-each происходит последовательно, переходя по ссылкам между элементами.
        */
        List<Integer> list = new LinkedList<>();  // Создаем пустой связанный список

        // Добавляем числа от 1 до 15 в начало списка (чтобы они были в обратном порядке)
        for (int i = 1; i <= 15; i++) {
            list.addFirst(i); // Вставка в начало списка
        }

        // Вычисляем произведение элементов списка
        long result = 1;
        for (int el : list) {
            result *= el;
        }

        // Выводим результат
        System.out.println("Список: " + list);
        System.out.println("Произведение элементов: " + result);
    }
}