import java.util.*;

class Graph {
    int V, E;
    List<Edge> edges;

    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
    }

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    void bellmanFord(int source) {
        int[] distance = new int[V];
        int[] parent = new int[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        distance[source] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.src] + edge.weight;
                    parent[edge.dest] = edge.src;
                }
            }
        }

        for (Edge edge : edges) {
            if (distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]) {
                System.out.println("This graph contains a negative-weight cycle");
                return;
            }
        }

        System.out.println("1) Number of vertices: " + V + ", Number of edges: " + E);
        System.out.println("2) Table of d values:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

        System.out.println("3) Table of π values:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("null");
            } else {
                if (parent[i] == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(parent[i]);
                }
            }
        }
    }
}

public class ModifiedBellmanFord {
    public static void main(String[] args) {

        // G3
        // int V = 8;
        // int E = 13;
        // Graph graph3 = new Graph(V, E);

        // graph3.addEdge(0,1,6);
        // graph3.addEdge(0,2,5);
        // graph3.addEdge(0,3,-4);
        // graph3.addEdge(1,4,1);
        // graph3.addEdge(1,5,5);
        // graph3.addEdge(2,1,2);
        // graph3.addEdge(2,6,3);
        // graph3.addEdge(2,3,-1);
        // graph3.addEdge(3,6,2);
        // graph3.addEdge(4,5,-2);
        // graph3.addEdge(5,7,-3);
        // graph3.addEdge(6,5,1);
        // graph3.addEdge(7,4,4);

        // int source = 0;
        // graph3.bellmanFord(source);
        // G3

        // G4
        int V = 10;
        int E = 17;
        Graph graph4 = new Graph(V, E);

        graph4.addEdge(0,1,6);
        graph4.addEdge(0,2,-1);
        graph4.addEdge(0,3,5);
        graph4.addEdge(1,2,1);
        graph4.addEdge(1,4,-4);
        graph4.addEdge(2,3,2);
        graph4.addEdge(2,5,3);
        graph4.addEdge(3,5,7);
        graph4.addEdge(3,6,-2);
        graph4.addEdge(4,5,2);
        graph4.addEdge(5,1,6);
        graph4.addEdge(5,6,5);
        graph4.addEdge(5,8,5);
        graph4.addEdge(6,9,3);
        graph4.addEdge(7,4,4);
        graph4.addEdge(7,8,-3);
        graph4.addEdge(8,9,1);

        int source = 0;
        graph4.bellmanFord(source);
        // G4
    }
}
