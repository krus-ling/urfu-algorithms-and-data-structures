import java.util.Arrays;

public class Sorting_12 {

    // 1. Пузырьковая сортировка
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }


    // 2. Сортировка выбором
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            // Поиск минимального элемента
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Обмен с первым неотсортированным
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    // 3. Сортировка выбором
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i]; // это текущий индекс элемента, который мы хотим вставить в отсортированную часть массива
            int j = i - 1; // это последний индекс в уже отсортированной части

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j]; // сдвигаем вправо
                j--;
            }

            arr[j + 1] = current; // вставляем на нужное место
        }
    }


    // 4. Сортировка подсчетом
    public static void countingSort(int[] arr) {

        if (arr.length == 0) return;

        // Определяем диапазон значений
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;
        int[] count = new int[range];

        // Подсчитываем вхождение каждого значения
        for (int num : arr) {
            count[num - min]++;
        }

        // Собираем отсортированный массив
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }


    // Метод для вывода массива
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] original = {64, 25, 12, 22, 11, 7564, -45, 0};

        // Копируем массив для каждой сортировки
        int[] bubble = original.clone();
        int[] selection = original.clone();
        int[] insertion = original.clone();
        int[] counting = original.clone();

        System.out.println("Исходный массив:");
        printArray(original);

        bubbleSort(bubble);
        System.out.println("\nПузырьковая сортировка:");
        printArray(bubble);

        selectionSort(selection);
        System.out.println("\nСортировка выбором:");
        printArray(selection);

        insertionSort(insertion);
        System.out.println("\nСортировка вставками:");
        printArray(insertion);

        countingSort(counting);
        System.out.println("\nСортировка подсчётом:");
        printArray(counting);
    }
}
