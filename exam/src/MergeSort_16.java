public class MergeSort_16 {

    /**
     * Основной метод сортировки слиянием.
     * Принимает массив целых чисел и сортирует его.
     * @param array массив для сортировки
     */
    public static void mergeSort(int[] array) {

        // Проверяем, что массив не пустой и имеет более 1 элемента
        if (array == null || array.length < 2) {
            return;
        }

        // вызываем рекурсивную функцию сортировки с указанием границ массива
        mergeSort(array, 0, array.length - 1);

    }

    /**
     * Рекурсивная функция, которая делит массив на части и сортирует их.
     * @param array массив для сортировки
     * @param left индекс левого края подмассива
     * @param right индекс правого края подмассива
     */
    private static void mergeSort(int[] array, int left, int right) {

        // если подмассив состоит из одного элемента
        if (left >= right) {
            return;
        }

        // находим середину текущего подмассива
        int mid = left + (right - left) / 2;

        // рекурсивно сортируем левую половину массива
        mergeSort(array, left, mid);

        // рекурсивно сортируем правую половину
        mergeSort(array, mid + 1, right);

        // объединяем две отсортированные половины в один отсортированный массив
        merge(array, left, mid, right);

    }

    /**
     * Метод для слияния двух отсортированных подмассивов в один.
     * Подмассивы: array[left..mid] и array[mid+1..right]
     * @param array массив, содержащий два подмассива
     * @param left левый индекс первого подмассива
     * @param mid правый индекс первого подмассива (середина)
     * @param right правый индекс второго подмассива
     */
    public static void merge(int[] array, int left, int mid, int right) {

        // создаем временные массивы для левой и правой части
        int n1 = mid - left + 1; // длина левого подмассива
        int n2 = right - mid; // длина правого подмассива

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // копируем данные во временные подмассивы
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // инициализируем индексы для прохода по временному массиву
        int i = 0; // индекс для leftArray
        int j = 0; // индекс для rightArray
        int k = left; // индекс для исходного массива array

        // пока оба массива не закончились, сравниваем и записываем меньший элемент
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // если в leftArray остались элементы, добавляем их в array
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // если в rightArray остались элементы, добавляем их в array
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {

        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Исходный массив");
        Sorting_12.printArray(arr);

        mergeSort(arr);

        System.out.println("Отсортированный массив");
        Sorting_12.printArray(arr);
    }
}
