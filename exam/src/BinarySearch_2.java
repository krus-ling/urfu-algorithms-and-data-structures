public class BinarySearch_2 {

    public static void search(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                System.out.printf("Элемент %d найден на индексе %d\n", key, mid);
                return;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.printf("Элемент %d не найден в массиве\n", key);
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 9, 45, 89, 256, 789, 890, 8562, 1000889};

        int key = 4;
        search(arr, key);

    }
}
