package Leet_Code_Questions;

import java.util.Arrays;

public class IsBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !helper(graph, i, 0, color))
                return false;
        }

        return true;
    }

     public boolean helper(int[][] graph, int node, int c , int[] color ){
         color[node] = c;
         for (int nei : graph[node]) {
             if (color[nei] == -1) {
                 if (!helper(graph, nei, 1 - c, color))
                     return false;
             } else if (color[nei] == c)
                 return false;
         }
         return true;
     }
     
    public static void main(String[] args) {

    }

}
