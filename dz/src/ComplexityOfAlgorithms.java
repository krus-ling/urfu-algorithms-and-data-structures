public class ComplexityOfAlgorithms {

    /**
     * Функция выполняет быструю сортировку массива
     * @param arr массив чисел, который нужно отсортировать
     * @param left начальный индекс
     * @param right конечный индекс
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // Разбиение массива
            quickSort(arr, left, pivotIndex - 1); // Рекурсивная сортировка левой части
            quickSort(arr, pivotIndex + 1, right); // Рекурсивная сортировка правой части
        }
    }

    /**
     * Функция разбиения массива на 2 части относительно опорного элемента
     * @param arr массив чисел
     * @param left начальный индекс
     * @param right конечный индекс
     * @return индекс опорного элемента после разбиения
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Выбираем правый элемент как опорный
        int i = left - 1; // Индекс наименьшего элемента
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Обмен элементов
            }
        }

        swap(arr, i + 1, right); // Перемещаем опорный элемент на правильное место
        return i + 1;
    }

    /**
     * Вспомогательная функция для обмена элементов массива
     * @param arr массив чисел
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
