import java.util.*;

class Edge {
    String target;
    int weight;

    Edge(String target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Graph{

    protected Map<String, List<Edge>> adjList = new TreeMap<>();

    public void addVertex(String v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(String u, String v, int weight) {
        addVertex(u);
        addVertex(v);
        adjList.get(u).add(new Edge(v, weight));
        adjList.get(v).add(new Edge(u, weight));
    }

    public void printGraph() {
        for (String v : adjList.keySet()) {
            System.out.print(v + " : ");
            for (Edge e : adjList.get(v)) {
                System.out.print("[" + e.target + ", w:" + e.weight + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("B", "A", 9);
        graph.addEdge("C", "A", 9);
        graph.addEdge("D", "A", 9);
        graph.addEdge("E", "C", 7);
        graph.addEdge("E", "B", 6);
        graph.printGraph();
    }
}