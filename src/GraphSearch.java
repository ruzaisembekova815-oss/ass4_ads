import java.util.*;

public class GraphSearch extends Graph {

    public void bfs(String startNode) {
        System.out.print("BFS Traversal Order: ");
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            System.out.print(curr + " ");
            for (Edge e : adjList.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(e.target)) {
                    visited.add(e.target);
                    queue.add(e.target);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String startNode) {
        System.out.print("DFS Traversal Order: ");
        dfsHelper(startNode, new HashSet<>());
        System.out.println();
    }

    private void dfsHelper(String node, Set<String> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (Edge e : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(e.target)) {
                dfsHelper(e.target, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphSearch search = new GraphSearch();
        search.addEdge("B", "A", 9);
        search.addEdge("C", "A", 9);
        search.addEdge("D", "A", 9);
        search.addEdge("E", "C", 7);
        search.addEdge("E", "B", 6);


        search.bfs("A");
        search.dfs("A");
    }
}
