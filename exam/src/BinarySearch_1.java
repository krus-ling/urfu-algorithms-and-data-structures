import java.util.Arrays;
import java.util.Random;

public class BinarySearch_1 {

    public static int search(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                System.out.printf("Элемент %d найден на индексе %d\n", key, mid);
                return arr[mid];
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.printf("Элемет %d не найден в массиве\n", key);
        return -1;
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        Arrays.sort(arr);

//        for (int i : arr) {
//            System.out.println(arr[i]);
//        }

        int key = 41;
        int result = search(arr, key);

    }
}
