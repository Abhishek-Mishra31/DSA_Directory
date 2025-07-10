package Domain_Camp_Questions;

public class Shortest_Distance_Cities_DAY_3 {
        static final int INF = 99999;

        public static void floydWarshall(int[][] graph) {
            int V = graph.length;
            int[][] dist = new int[V][V];

            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    dist[i][j] = graph[i][j];

            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] + dist[k][j] < dist[i][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }

            System.out.println("Shortest distances between every pair of cities:");
            for (int i = 0; i < V; ++i) {
                for (int j = 0; j < V; ++j) {
                    if (dist[i][j] == INF)
                        System.out.print("INF ");
                    else
                        System.out.print(dist[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int[][] cityGraph = {
                    {0, 3, INF, 5},
                    {2, 0, INF, 4},
                    {INF, 1, 0, INF},
                    {INF, INF, 2, 0}
            };

            floydWarshall(cityGraph);
        }
    }


