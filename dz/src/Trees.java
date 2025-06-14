import java.util.LinkedList;
import java.util.Queue;

// Реализация через очередь
public class Trees {
    /**
     * Метод для выполнения обхода в ширину в графе
     * @param graph матрица смежности графа, где graph[i][j] == 1 означает наличие ребра между вершинами i и j
     * @param startVertex индекс начальной вершины, с которой начинается обход
     */
    public static void bfs(int[][] graph, int startVertex) {

        // Массив для отслеживания посещенных вершин
        boolean[] visited = new boolean[graph.length];

        // Очередь для хранения вершин, которые нужно посетить
        Queue<Integer> queue = new LinkedList<>();

        // Помещаем стартовую вершину в очередь и отмечаем как посещенную
        queue.add(startVertex);
        visited[startVertex] = true;

        System.out.println("Обход в ширину, начиная с вершины " + startVertex);

        // Пока в очереди есть вершины для посещения
        while (!queue.isEmpty()) {
            // Извлекаем вершины из очереди
            int vertex = queue.poll();
            System.out.println(vertex + " "); // Выводим текущую вершину

            // Проходим по всем соседям текущей вершины
            for (int i = 0; i < graph[vertex].length; i++) {
                // Если вершина i является соседом и еще не была посещена
                if (!visited[i] && graph[vertex][i] == 1) {
                    queue.add(i);      // Добавляем вершину в очередь
                    visited[i] = true; // Отмечаем вершину как посещенную
                }
            }
        }
    }

    public static void main(String[] args) {
        // Пример неориентированного графа в виде матрицы смежности
        // 0 — 1 — 2
        // |   |
        // 3 — 4
        int[][] graph = {
                {0, 1, 0, 1, 0}, // Вершина 0
                {1, 0, 1, 0, 1}, // Вершина 1
                {0, 1, 0, 0, 0}, // Вершина 2
                {1, 0, 0, 0, 1}, // Вершина 3
                {0, 1, 0, 1, 0}  // Вершина 4
        };

        // Запускаем обход в ширину
        bfs(graph, 0);
    }
}
