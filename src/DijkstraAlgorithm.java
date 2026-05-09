import java.util.*;

public class DijkstraAlgorithm extends Graph {

    public void computeDijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();

        PriorityQueue<NodeDist> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));

        for (String v : adjList.keySet()) {
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new NodeDist(start, 0));

        while (!pq.isEmpty()) {
            NodeDist current = pq.poll();
            if (current.dist > distances.get(current.name)) continue;

            for (Edge e : adjList.get(current.name)) {
                int newDist = distances.get(current.name) + e.weight;
                if (newDist < distances.get(e.target)) {
                    distances.put(e.target, newDist);
                    predecessors.put(e.target, current.name);
                    pq.add(new NodeDist(e.target, newDist));
                }
            }
        }


        for (String v : distances.keySet()) {
            System.out.print("To " + v + ": Distance = " + distances.get(v) + ", Path = ");
            printPath(v, predecessors);
            System.out.println();
        }
    }

    private void printPath(String target, Map<String, String> predecessors) {
        LinkedList<String> path = new LinkedList<>();
        for (String at = target; at != null; at = predecessors.get(at)) {
            path.addFirst(at);
        }
        System.out.print(path);
    }

    private static class NodeDist {
        String name; int dist;
        NodeDist(String n, int d) { name = n; dist = d; }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        dijkstra.addEdge("B", "A", 9);
        dijkstra.addEdge("C", "A", 9);
        dijkstra.addEdge("D", "A", 9);
        dijkstra.addEdge("E", "C", 7);
        dijkstra.addEdge("E", "B", 6);

        // Согласно входным данным, начинаем с 'C'
        dijkstra.computeDijkstra("C");
    }
}