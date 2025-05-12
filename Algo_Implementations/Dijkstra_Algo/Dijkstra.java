package CU_Practice_Programs.Algo_Implementations.Dijkstra_Algo;

import java.util.*;

class Dijkstra {
    private static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    static class Graph {
        int vertices;
        List<Edge>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v, int weight) {
            adjList[u].add(new Edge(v, weight));
        }
    }

    public static void dijkstra(Graph graph, int source) {
        int[] dist = new int[graph.vertices];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Edge edge : graph.adjList[u]) {
                int v = edge.target, weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        printSolution(dist);
    }

    private static void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance");
        for (int i = 1; i < dist.length; i++) {
            System.out.println(i + " \t " + (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1, 2, 7);
        graph.addEdge(2, 4, 15);
        graph.addEdge(1, 6, 14);
        graph.addEdge(1, 3, 9);
        graph.addEdge(3, 6, 2);
        graph.addEdge(3, 4, 11);
        graph.addEdge(4, 5, 6);
        graph.addEdge(6, 5, 9);

        dijkstra(graph, 1);
    }
}

