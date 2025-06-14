import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithms {

    /**
     * Класс для представления коробки с двумя параметрами:
     * weight - вес самой коробки
     * maxLoad - максимальный вес, который можно положить сверху на эту коробку
     */
    static class Box {
        int weight;
        int maxLoad;

        Box(int weight, int maxLoad) {
            this.weight = weight;
            this.maxLoad = maxLoad;
        }
    }

    /**
     * Метод для вычисления максимального количества коробок, которые можно сложить в стопку
     * @param boxes массив коробок
     * @return максимальное количество коробок в валидной стопке
     */
    public static int maxBoxesInStack(Box[] boxes) {
        // Сортируем коробки по возрастанию (weight + maxLoad)
        Arrays.sort(boxes, Comparator.comparingInt(b -> (b.weight + b.maxLoad)));

        int n = boxes.length;
        // Массив для динамического программирования:
        // dp[i] хранит минимальный возможный вес стопки из i коробок
        int[] dp = new int[n + 1];
        // Инициализируем массив максимальными значениями
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Стопка из 0 коробок имеет вес 0
        dp[0] = 0;

        // Переменная для хранения максимального найденного размера стопки
        int maxStack = 0;

        // Перебираем все коробки в отсортированном порядке
        for (Box box : boxes) {
            // Проверяем в обратном порядке, чтобы не учитывать коробку несколько раз
            for (int i = maxStack; i >= 0; i--) {
                // 1. Текущая коробка может выдержать вес стопки из i коробок
                // 2. Добавление текущей коробки уменьшает общий вес стопки из i+1 коробок
                if (box.maxLoad >= dp[i] && dp[i] + box.weight < dp[i + 1]) {
                    // Обновляем вес стопки из i+1 коробок
                    dp[i + 1] = dp[i] + box.weight;
                    // Обновляем максимальный размер стопки при необходимости
                    if (i + 1 > maxStack) {
                        maxStack = i + 1;
                    }
                }
            }
        }

        return maxStack;
    }

    public static void main(String[] args) {
        // Создаем тестовый набор коробок
        Box[] boxes = {
                new Box(10, 11),
                new Box(20, 100),
                new Box(30, 10)
        };

        int result = maxBoxesInStack(boxes);
        System.out.println("Максимальное количество коробок в стопке: " + result);
    }
}