import java.util.ArrayList;
import java.util.List;

public class Heap {

    // Внутренне представление кучи — список
    private final List<Integer> heap;

    // Конструктор — инициализация пустой кучи
    public Heap() {
        heap = new ArrayList<>();
    }

    /**
     * Метод для вставки нового элемента в кучу
     * @param value значение, которое нужно вставить
     */
    public void insert(int value) {

        // Добавляем элемент в конец списка
        heap.add(value);

        // Получаем индекс добавленного элемента
        int index = heap.size() - 1;

        // Восстанавливаем свойства кучи
        // (Значение каждой родительской вершины меньше, чем все значения в ее поддереве)
        while (index > 0) {

            // Находим индекс родительского элемента
            int parentIndex = (index - 1) / 2;

            // Если родитель больше текущего, то меняем местами
            if (heap.get(index) < heap.get(parentIndex)) {
                swap(index, parentIndex); // Меняем местами
                index = parentIndex;      // Поднимаемся к родителю
            } else {
                break; // Свойство кучи не выполнено, и выходим из цикла
            }
        }
    }

    /**
     * Вспомогательный метод для обмена значений по индексам
     * @param x индекс первого элемента
     * @param y индекс второго элемента
     */
    public void swap(int x, int y) {
        int temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

    // Для отображения содержимого кучи
    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {

        Heap heap = new Heap();

        // Добавляем элементы
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(8);

        // Вывод результата
        System.out.printf("Текущая куча: %s", heap);
    }
}