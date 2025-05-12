package CU_Practice_Programs.Algo_Implementations.Dynamic_Programming;

import java.util.*;

public class Warshall_algo {
    int V;
    int[][] reach;

    public Warshall_algo(int vertices) {
        this.V = vertices;
        reach = new int[V][V];
        for (int i = 0; i < V; i++) {
            reach[i][i] = 1;
        }
    }

    public void addEdge(int u, int v) {
        reach[u][v] = 1;
    }

    public void warshallAlgo() {

        for (int k = 0; k < V; k++) {

            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {

                    if (reach[i][k] == 1 && reach[k][j] == 1) {
                        reach[i][j] = 1;
                    }
                }
            }
        }
    }

    public void printTransitiveClosures() {
        System.out.println("Transitive Closure (Reachability Matrix):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(reach[i][j] + "");
            }
            System.out.println();
        }

    }

    // Main method to run the code
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Warshall_algo graph = new Warshall_algo(4);

        // Add edges along with weights
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(1, 2);

        graph.warshallAlgo();

        graph.printTransitiveClosures();
    }
}

