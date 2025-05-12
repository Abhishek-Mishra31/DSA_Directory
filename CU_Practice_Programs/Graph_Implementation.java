package CU_Practice_Programs;

import java.util.ArrayList;
import java.util.List;

// this is directed graph example
public class Graph_Implementation {
    private class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest , int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return src + "->" + dest + "-" + weight;
        }
    }

        int vertices;
        List<Edge> edges;

       public Graph_Implementation(int vertices){
            this.vertices = vertices;
            this.edges = new ArrayList<>();
        }

        public void addEdge(int src, int dest , int weight){
           // we are adding edges in directed graph, for in Un-directed graph we need to call this function twice.
           edges.add(new Edge(src, dest , weight));
        }

        public void printGraphFunc(){
            System.out.println("Graph:- ");
            for(Edge edge : edges){
                System.out.println(edge.src + " -> " + edge.dest + " - " + edge.weight);
            }
        }


    public static void main(String[] args) {
        Graph_Implementation graph = new Graph_Implementation(5);
        graph.addEdge(0 , 1 , 4);
        graph.addEdge(0 , 2 , 3);
        graph.addEdge(1 , 3 , 8);
        graph.addEdge(2 , 3 , 5);
        graph.printGraphFunc();
    }

}
