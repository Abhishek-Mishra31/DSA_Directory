package Leet_Code_Questions;

public class knapsack_problem_GFG {

    static int knapsack(int capicity, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][capicity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capicity; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capicity];
    }

    public static void main(String[] args) {
        int capicity = 4;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 1};

        System.out.println(knapsack(capicity, val, wt));
    }
}
