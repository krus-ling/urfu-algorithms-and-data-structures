import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearch {
    /**
     * Алгоритм бинарного поиска
     *
     * @param arr    Отсортированный массив элементов
     * @param target Искомый элемент
     * @return Индекс элемента в массиве или -1, если элемент не найден
     */

    public static int binarySearch(int[] arr, int target) {

        // Границы поиска
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Находим середину диапазона
            System.out.printf("середина - %d; left - %s; right - %s\n", mid, left, right);
            // Этот способ безопаснее, чем (right + left) / 2, т.к. при больших числах int может переполниться

            if (arr[mid] == target) {
                return mid; // Если элемент найден, возвращаем его индекс
            } else if (arr[mid] < target) { // Если середина левее искомого элемента
                left = mid + 1; // Двигаем левую границу, сужая поиск
            } else { // Если середина правее искомого элемента
                right = mid - 1; // Двигаем правую границу, сужая поиск
            }
        }

        return -1; // Возвращаем -1, если элемент не найден
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 9, 45, 89, 256, 789, 890, 8562, 1000889};
        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);

        int target = 789;
        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.printf("Элемент %s найден на индексе %s", target, result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
