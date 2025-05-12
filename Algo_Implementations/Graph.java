package CU_Practice_Programs.Algo_Implementations;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    static class Edge implements Comparable<Edge>{
        int src , dest , weight;

        public Edge(int src, int dest , int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return src + "- " + dest + " - " + weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight , o.weight);
        }
    }

    int Vertices;
    List<Edge> edges;

    public Graph(int vertices){
        this.Vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int src , int dest , int weight){
        edges.add(new Edge(src, dest, weight));
    }

    public void printGraph(){
        System.out.println("Graph Edges: ");
        for(Edge edge : edges){
            System.out.println(edge.src + " -> " + edge.dest + " - " + edge.weight);
        }
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public void kruskalMST() throws Exception {
//        Collections.sort(edges);
        List<Edge> sortedList = HeapEdgesSort.Heap.sortEdges(edges);
        System.out.println(sortedList);

        int[] parent = new int[Vertices];

        for (int i = 0; i < Vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();
        int totalCost = 0; 

        for (Edge edge : sortedList) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            if (rootSrc != rootDest) {
                mst.add(edge);
                totalCost += edge.weight;
                union(parent, rootSrc, rootDest);
            }
        }

        System.out.println("Minimum Cost Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
        System.out.println("Total Cost: " + totalCost);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}


