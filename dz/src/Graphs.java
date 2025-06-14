import java.util.*;

public class Graphs {

    // Класс, представляющий граф с использованием списка смежности
    static class Graph {
        private final int numVertices; // Количество вершин в графе
        private final LinkedList<Integer>[] adjacencyList; // Массив списков смежности

        /**
         * Конструктор графа
         * @param vertices количество вершин
         */
        public Graph(int vertices) {
            this.numVertices = vertices;
            adjacencyList = new LinkedList[vertices];

            // Инициализация списков смежности для всех вершин
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        /**
         * Метод добавления ребра в граф (для неориентированного графа)
         * @param source      начальная вершина ребра
         * @param destination конечная вершина ребра
         */
        public void addEdge(int source, int destination) {
            // Добавляем вершины друг к другу в списки смежности
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source); // Не нужно для ориентированного графа
        }

        /**
         * Метод обхода в ширину из заданной стартовой вершины
         * @param startVertex начальная вершина
         */
        public void bfs(int startVertex) {
            // Массив для отслеживания посещенных вершин
            boolean[] visited = new boolean[numVertices];

            // Очередь для вершин, ожидающих обработки
            Queue<Integer> queue = new LinkedList<>();

            // Помечаем начальную вершину как посещённую и добавляем в очередь
            visited[startVertex] = true;
            queue.add(startVertex);

            System.out.printf("Обход в ширину (BFS), начиная с вершины %s: ",startVertex);

            // Пока в очереди есть вершины
            while (!queue.isEmpty()) {
                // Извлекаем вершину из очереди и обрабатываем
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                // Получаем всех соседей текущей вершины
                for (int neighbor : adjacencyList[currentVertex]) {
                    // Если сосед ещё не был посещён
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;  // Помечаем как посещённого
                        queue.add(neighbor);       // Добавляем в очередь для дальнейшего обхода
                    }
                }
            }

            System.out.println(); // Перевод строки после обхода
        }
    }

    // Пример
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Создаем граф с 6 вершинами (от 0 до 5)

        // Добавляем ребра между вершинами
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // Запускаем обход в ширину начиная с вершины 0
        graph.bfs(0);
    }
}
