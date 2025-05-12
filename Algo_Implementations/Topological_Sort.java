package CU_Practice_Programs.Algo_Implementations;

import java.util.ArrayList;
import java.util.List;

public class Topological_Sort {
    static class Graph {
        int vertices;
        List<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        void addEdge(int value, int target) {
            adjList[value].add(target);
        }

        void topologicalSort() {
            boolean[] visited = new boolean[vertices];
            int[] result = new int[vertices];
            int[] index = {vertices - 1};


            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    dfs(i, visited, result, index);
                }
            }

            System.out.println("Topological Sort Order:");
            for (int i = 0; i < vertices; i++) {
                System.out.print(result[i] + " ");
            }
        }

        void dfs(int node, boolean[] visited, int[] result, int[] index) {
            visited[node] = true;

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, result, index);
                }
            }
            result[index[0]--] = node;
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);

        // Adding edges using addEdge method
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // Perform Topological Sort
        graph.topologicalSort();
    }
}
