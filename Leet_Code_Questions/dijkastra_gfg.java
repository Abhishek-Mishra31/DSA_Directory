package Leet_Code_Questions;

import java.util.*;

public class dijkastra_gfg {

    public int[] dijkstra(int V, int[][] edges, int src) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});

        }


        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

    }
}
