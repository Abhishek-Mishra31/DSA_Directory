package Leet_Code_Questions;

public class Kth_Ancestor {

        private int[][] dp;
        private int LOG;

        public Kth_Ancestor(int n, int[] parent) {
            LOG = (int)(Math.log(n) / Math.log(2)) + 1;
            dp = new int[n][LOG];

            // Initialize dp for 2^0 (immediate parent)
            for (int i = 0; i < n; i++) {
                dp[i][0] = parent[i];
            }

            // Build sparse table
            for (int j = 1; j < LOG; j++) {
                for (int i = 0; i < n; i++) {
                    int prev = dp[i][j - 1];
                    dp[i][j] = (prev == -1 ? -1 : dp[prev][j - 1]);
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int j = 0; j < LOG && node != -1; j++) {
                if ((k & (1 << j)) != 0) {
                    node = dp[node][j];
                }
            }
            return node;
        }


}
