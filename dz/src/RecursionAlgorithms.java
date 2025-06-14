
public class RecursionAlgorithms {
    /**
     * Рекурсивное слияние двух отсортированных массивов
     *
     * @param arr1 первый отсортированный массив
     * @param arr2 второй отсортированный массив
     * @param merged объединенный массив, в который записываются элементы
     * @param i текущий индекс в первом массиве
     * @param j текущий индекс во втором массиве
     * @param k текущий индекс в результирующем массиве
     */

    public static void mergeRecursive(int[] arr1, int[] arr2, int[] merged, int i, int j, int k) {

        // Если первый массив полностью обработан,
        // копируем оставшиеся элементы второго массива и завершаем рекурсию.
        if (i == arr1.length) {
            System.arraycopy(arr2, j, merged, k, arr2.length - j);
            return;
        }

        // Если второй массив полностью обработан,
        // копируем оставшиеся элементы первого массива и завершаем рекурсию.
        if (j == arr2.length) {
            System.arraycopy(arr1, i, merged, k, arr1.length - i);
            return;
        }

        // Сравниваем текущие элементы двух массивов.
        // Берем наименьший и добавляем его в результирующий массив.
        if (arr1[i] < arr2[j]) {
            merged[k] = arr1[i]; // Добавляем arr1[i] в merged
            mergeRecursive(arr1, arr2, merged, i + 1, j, k + 1); // Сдвигаем индексы у соответствующих массивов
        } else {
            merged[k] = arr2[j]; // Добавляем arr2[j] в merged
            mergeRecursive(arr1, arr2, merged, i, j + 1, k + 1); // Сдвигаем индексы у соответствующих массивов
        }
    }

    /**
     * Метод для объединения двух отсортированных массивов.
     * Создает результирующий массив и вызывает рекурсивную функцию для слияния.
     *
     * @param arr1 первый отсортированный массив
     * @param arr2 второй отсортированный массив
     * @return объединенный отсортированный массив
     */

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        mergeRecursive(arr1, arr2, merged, 0, 0, 0); // Запуск рекурсивного слияния с начальных индексов
        return merged;
    }
}
