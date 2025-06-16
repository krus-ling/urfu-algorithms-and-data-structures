import java.util.ArrayList;
import java.util.List;

public class BFS_29 {

    // метод обхода графа в ширину с двумя списками
    public static void bfs(int start, List<List<Integer>> graph, int n) {

        boolean[] visited = new boolean[n]; // массив посещенных вершин

        List<Integer> currentLevel = new ArrayList<>(); // текущий уровень
        List<Integer> nextLevel = new ArrayList<>(); // следующий уровень

        // начинаем обход с корня – start
        currentLevel.add(start);
        visited[start] = true;

        System.out.println("BFS обход: ");

        // пока текущий уровень не пуст
        while (!currentLevel.isEmpty()) {

            // проходим по всем вершинам текущего уровня
            for (int node : currentLevel) {
                System.out.print(node + " "); // печатаем вершину

                // добавляем всех непосещенных соседей в следующий уровень
                for (int child : graph.get(node)) {
                    if (!visited[child]) {
                        nextLevel.add(child);
                        visited[child] = true;
                    }
                }
            }

            // переходим на следующий уровень
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>(); // очищаем список следующего уровня
        }
    }

    public static void main(String[] args) {

        int n = 6; // количество вершин в графе
        List<List<Integer>> graph = new ArrayList<>();

        // инициализируем список смежности для каждой вершины
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        graph.get(2).add(5);
        graph.get(5).add(2);

        bfs(0, graph, n);
    }
}
