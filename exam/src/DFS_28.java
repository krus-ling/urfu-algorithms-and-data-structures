import java.util.ArrayList;
import java.util.List;

public class DFS_28 {

    // метод обхода в глубину
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {

        visited[node] = true; // отмечаем текущую вершину как посещенную
        System.out.println(node + " "); // печатаем вершину

        // проходим по всем соседям текущей вершины
        for (int child : graph.get(node)) {
            if (!visited[child]) {
                // если сосед еще не посещен
                dfs(child, visited, graph);
            }
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

        boolean[] visited = new boolean[n];

        System.out.println("DFS обход: ");
        dfs(0, visited, graph);
    }
}
