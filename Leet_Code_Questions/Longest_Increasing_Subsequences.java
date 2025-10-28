package Leet_Code_Questions;

public class Longest_Increasing_Subsequences {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr2 = {1,1,1,2,2,3,4,4};

        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLIS(arr2));

    }

}
