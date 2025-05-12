package CU_Practice_Programs.Algo_Implementations.Dynamic_Programming;

import java.util.Arrays;

public class Knapsack_Problem {

    static int[][] dp_memo;

    public static int knapsack(int[] weights, int[] values, int capacity, int index) {
        if (index == 0 || capacity == 0) {
            return 0;
        }

        if (dp_memo[index][capacity] != -1) {
            return dp_memo[index][capacity];
        }

        if (weights[index - 1] > capacity) {
            dp_memo[index][capacity] = knapsack(weights, values, capacity, index - 1);
        } else {
            int notTake = knapsack(weights, values, capacity, index - 1);

            int take = values[index - 1] + knapsack(weights, values, capacity - weights[index - 1], index - 1);

            dp_memo[index][capacity] = Math.max(take, notTake);
        }
        return dp_memo[index][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1500, 2000, 3000, 3500};
        int capacity = 7;
        int n = weights.length;

        dp_memo = new int[n + 1][capacity + 1];
        for (int[] row : dp_memo) {
            Arrays.fill(row, -1);
        }

        int maxVal = knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + maxVal);
    }
}

