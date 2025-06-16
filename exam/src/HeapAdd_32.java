import java.util.ArrayList;
import java.util.List;

public class HeapAdd_32 {

    private final List<Integer> heap = new ArrayList<>(); // хранилище кучи

    // добавление элемента с сохранением свойств min-heap
    public void insert(int value) {
        heap.add(value); // добавляем элемент в конец списка
        siftUp(heap.size() - 1); // восстанавливаем кучу вверх от добавленного элемента
    }

    // вспомогательный метод "всплытия" элемента наверх
    private void siftUp(int index) {

        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent; // продолжаем подниматься
            } else {
                break; // куча восстановлена
            }
        }
    }

    // обмен элементов по индексам
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // печать текущей кучи
    public void printHeap() {
        System.out.printf("Heap: %s\n", heap);
    }

    public static void main(String[] args) {

        HeapAdd_32 heap = new HeapAdd_32();

        heap.insert(15);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        heap.printHeap();
    }
}
