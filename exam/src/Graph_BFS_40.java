import java.util.*;

/**
 * Класс Graph представляет граф с операцией обхода в ширину (BFS).
 */
public class Graph_BFS_40 {

   // список смежности: каждая вершина хранит список соседей
   private final Map<Integer, List<Integer>> adjList = new HashMap<>();

   public void addEdge(int from , int to) {

       adjList.computeIfAbsent(from, _ -> new ArrayList<>()).add(to);
       // для неориентированного графа нужно добавить:
       // adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
   }

    /**
     * Выполняет обход графа в ширину начиная с заданной вершины.
     *
     * @param start вершина, с которой начинает bfs
     */
   public void bfs(int start) {

       Set<Integer> visited = new HashSet<>();    // множество посещенных вершин
       Queue<Integer> queue = new LinkedList<>(); // очередь для bfs

       queue.add(start);   // помещаем стартовую вершину в очередь
       visited.add(start); // помечаем ее как посещенную

       System.out.printf("Обход в ширину (BFS), начиная с вершины %s:\n", start);

       // пока очередь не пустая
       while (!queue.isEmpty()) {
           int current = queue.poll(); // извлекаем вершину из очереди
           System.out.println(current + " ");

           // Обходим всех соседей текущей вершины
           for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
               if (!visited.contains(neighbor)) {
                   queue.add(neighbor);   // добавляем непосещенного соседа в очередь
                   visited.add(neighbor); // и помечаем его как посещенного
               }
           }
       }

       System.out.println(); // перенос строки после вывода
   }


    public static void main(String[] args) {

       Graph_BFS_40 graph = new Graph_BFS_40();

       graph.addEdge(0, 1);
       graph.addEdge(0, 2);
       graph.addEdge(1, 3);
       graph.addEdge(1, 4);
       graph.addEdge(2, 5);
       graph.addEdge(4, 5);

       graph.bfs(0);
    }
}
