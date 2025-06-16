import java.util.ArrayList;
import java.util.List;

public class HeapRemove_33 {

    // Список, реализующий кучу (мин-куча: родитель ≤ потомки)
    private final List<Integer> heap = new ArrayList<>();

    // Получить индекс родителя элемента по индексу
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Получить индекс левого потомка элемента по индексу
    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    // Получить индекс правого потомка элемента по индексу
    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    // Проверка, существует ли элемент с данным индексом
    private boolean exists(int index) {
        return index >= 0 && index < heap.size();
    }


    // Удаление произвольного элемента по значению
    public boolean remove(int value) {
        int index = heap.indexOf(value); // Поиск индекса элемента
        if (index == -1) {
            return false; // Элемент не найден
        }

        System.out.printf("Элемент %s удален: ", value);
        return removeAt(index); // Удаление по индексу
    }

    // Удаление элемента по индексу
    private boolean removeAt(int index) {
        if (!exists(index)) {
            return false; // Индекс за пределами списка
        }

        // Если удаляем последний элемент — просто удаляем
        if (index == heap.size() - 1) {
            heap.remove(index);
            return true;
        }

        // Меняем удаляемый элемент с последним
        swap(index, heap.size() - 1);
        heap.removeLast(); // Удаляем последний элемент

        // Пробуем просеивание вверх (если элемент стал меньше родителя)
        siftUp(index);

        // Если элемент не переместился вверх — пробуем просеять вниз
        if (index < heap.size()) {
            siftDown(index);
        }

        return true;
    }


    // Просеивание вниз: восстанавливает свойство мин-кучи, начиная с index
    private void siftDown(int index) {
        int smallest = index; // Изначально считаем текущий элемент наименьшим
        int left = leftChild(index); // Индекс левого ребенка
        int right = rightChild(index); // Индекс правого ребенка

        // Если левый ребенок существует и меньше текущего "наименьшего"
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left; // Теперь наименьший — левый ребенок
        }

        // Если правый ребенок существует и меньше текущего "наименьшего"
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right; // Теперь наименьший — правый ребенок
        }

        // Если наименьший — не текущий элемент, меняем их местами
        if (smallest != index) {
            swap(index, smallest); // Обмен значениями
            siftDown(smallest); // Рекурсивно продолжаем для новой позиции
        }
    }

    // Просеивание вверх: восстанавливает свойство мин-кучи после вставки
    private void siftUp(int index) {

        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index)); // Меняем местами с родителем
            index = parent(index); // Поднимаемся вверх
        }
    }

    // Обмен двух элементов местами в списке
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Вставка нового элемента в кучу
    public void insert(int value) {
        heap.add(value); // Добавляем в конец
        siftUp(heap.size() - 1); // Восстанавливаем кучу просеиванием вверх
    }

    // Извлечение минимального элемента (корня кучи)
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap.getFirst();
        removeAt(0);

        return min;
    }

    // Вывод элементов кучи
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        HeapRemove_33 heap = new HeapRemove_33();

        // Добавляем элементы в кучу
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(4);
        heap.insert(7);

        System.out.print("Куча после добавления элементов: ");
        heap.printHeap(); // [1, 3, 7, 5, 4, 8]

        // Удаляем минимальный элемент (корень)
        System.out.printf("Минимальный элемент – %s удален\n", heap.extractMin());
        System.out.print("Куча после удаления минимального: ");
        heap.printHeap(); // [3, 4, 7, 5, 8]

        // Удаляем элемент со значением 5
        boolean removed = heap.remove(5);
        System.out.println(removed); // true
        System.out.print("Куча после удаления 5: ");
        heap.printHeap(); // [3, 4, 7, 8]

        // Пытаемся удалить несуществующий элемент (например, 10)
        removed = heap.remove(10);
        System.out.println("Удален элемент 10: " + removed); // false
    }
}
