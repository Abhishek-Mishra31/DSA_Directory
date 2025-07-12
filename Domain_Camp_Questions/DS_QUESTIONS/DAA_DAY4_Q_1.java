package Domain_Camp_Questions.DS_QUESTIONS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAA_DAY4_Q_1 {
    static class SurveillanceGraph {
        int V;
        List<List<Integer>> adj;

        SurveillanceGraph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Set<Integer> minimumCameraCover() {
            boolean[] visited = new boolean[V];
            Set<Integer> cover = new HashSet<>();

            for (int u = 0; u < V; u++) {
                if (!visited[u]) {
                    for (int v : adj.get(u)) {
                        if (!visited[v]) {
                            visited[u] = visited[v] = true;
                            cover.add(u);
                            cover.add(v);
                            break;
                        }
                    }
                }
            }
            return cover;
        }
    }

    static class TimetableGraph {
        int V;
        List<List<Integer>> adj;

        TimetableGraph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addConflict(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean isColorable(int m) {
            int[] colors = new int[V];
            return solve(0, colors, m);
        }

        boolean solve(int node, int[] colors, int m) {
            if (node == V) return true;

            for (int c = 1; c <= m; c++) {
                if (isSafe(node, colors, c)) {
                    colors[node] = c;
                    if (solve(node + 1, colors, m))
                        return true;
                    colors[node] = 0;
                }
            }
            return false;
        }

        boolean isSafe(int node, int[] colors, int c) {
            for (int neighbor : adj.get(node))
                if (colors[neighbor] == c)
                    return false;
            return true;
        }
    }


    public static void main(String[] args) {

        SurveillanceGraph g1 = new SurveillanceGraph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);

        Set<Integer> cameras = g1.minimumCameraCover();
        System.out.println("Minimum cameras needed: " + cameras.size());
        System.out.println("Camera placements at nodes: " + cameras);


        TimetableGraph g2 = new TimetableGraph(4);
        g2.addConflict(0, 1); // Student takes exam 0 and 1
        g2.addConflict(1, 2); // Student takes exam 1 and 2
        g2.addConflict(2, 3); // Student takes exam 2 and 3

        int timeSlots = 2;
        boolean feasible = g2.isColorable(timeSlots);
        System.out.println("Feasible timetable with " + timeSlots + " time slots: " + feasible);

    }
}



