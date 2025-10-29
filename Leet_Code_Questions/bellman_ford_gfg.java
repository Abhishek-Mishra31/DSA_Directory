package Leet_Code_Questions;

import java.util.Arrays;

public class bellman_ford_gfg {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        final int INF = 100_000_000;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            boolean updated = false;
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] == INF) continue;
                long newDist = (long) dist[u] + (long) w;
                if (newDist < dist[v]) {
                    dist[v] = (int) newDist;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist[u] == INF) continue;
            long newDist = (long) dist[u] + (long) w;
            if (newDist < dist[v]) {
                return new int[] { -1 };
            }
        }

        return dist;
    }

}
