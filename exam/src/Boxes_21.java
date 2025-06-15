import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boxes_21 {

    private static class Box {
        int weight; // вес коробки
        int maxTop; // сколько может выдержать сверху

        Box(int weight, int maxTop) {
            this.weight = weight;
            this.maxTop = maxTop;
        }

        // Суммарная грузоподъемность = вес + сколько может выдержать сверху
        int totalCapacity() {
            return weight + maxTop;
        }
    }

    public static int maxBoxes(Box[] boxes) {

        // Сортировка по максимальной грузоподъемности
        Arrays.sort(boxes, Comparator.comparing(Box::totalCapacity));

        // PriorityQueue (max-heap) для хранения весов коробок в текущей стопке
        PriorityQueue<Integer> stackWeights = new PriorityQueue<>(Collections.reverseOrder());

        int currentWeight = 0; // текущая суммарная масса стопки

        for (Box box : boxes) {
            if (currentWeight <= box.maxTop) {
                // если текущая масса <= грузоподъемности – можно ставить
                stackWeights.add(box.weight);
                currentWeight += box.weight;
            } else if (!stackWeights.isEmpty() && stackWeights.peek() > box.weight) {
                // Если слишком тяжело, но вверху есть более тяжелая коробка –
                // заменить ее на эту, чтобы уменьшить вес
                int heaviest = stackWeights.poll();
                currentWeight -= heaviest;
                currentWeight += box.weight;
                stackWeights.add(box.weight);
            }
            // Иначе – пропускаем коробку, она не поможет улучшить результат
        }

        return stackWeights.size(); // размер очереди = высота стопки
    }

    public static void main(String[] args) {

        Box[] boxes = new Box[]{
                new Box(10, 11),
                new Box(20, 100),
                new Box(30, 10)
        };

        int result = maxBoxes(boxes);
        System.out.printf("Максимальное количество коробок в стопке: %d\n", result);
    }
}