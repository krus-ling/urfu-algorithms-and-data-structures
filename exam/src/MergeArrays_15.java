import java.util.Arrays;

public class MergeArrays_15 {

    /**
     * Главный метод объединения.
     * @param arr1 Первый массив
     * @param arr2 Второй массив
     * @return Новый массив, содержащий все элементы a и b
     */
    public static int[] mergeRecursive(int[] arr1, int[] arr2) {

        // создаем итоговый массив нужной длины
        int[] result = new int[arr1.length + arr2.length];

        // запускаем рекурсивную функцию, начиная с нулевых индексов
        return helper(arr1, arr2, 0, 0, result, 0);
    }

    /**
     * Рекурсивный вспомогательный метод, который копирует элементы из двух массивов
     * в результирующий массив по одному за вызов.
     * @param a Первый массив
     * @param b Второй массив
     * @param i Текущий индекс в массиве a
     * @param j Текущий индекс в массиве b
     * @param res Итоговый массив
     * @param k Текущий индекс в итоговом массиве res
     * @return Заполненный массив res
     */
    private static int[] helper(int[] a, int[] b, int i, int j, int[] res, int k) {

        // если оба массива уже обработаны
        if (i >= a.length && j >= b.length) {
            return res;
        }

        // проверяем элементы в a
        if (i < a.length) {
            res[k] = a[i];
            return helper(a, b, i + 1, j, res, k + 1);
        }

        // проверяем элементы в b
        if (j < b.length) {
            res[k] = b[j];
            return helper(a, b, i, j + 1, res, k + 1);
        }

        return res;
    }


    public static void main(String[] args) {

        int[] first = {1, 3, 5};
        int[] second = {2, 4, 6};

        int[] result = mergeRecursive(first, second);

        System.out.printf("Объединенный массив: %s\n", Arrays.toString(result));
    }
}
