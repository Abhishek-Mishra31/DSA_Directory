package CU_Practice_Programs.Algo_Implementations;

public class findSubsets {
    static void findSubsetsfunc(int[] S, int index, int sum, int target, String subset) {
        if (sum == target) {
            System.out.println("{" + subset.trim() + "}");
            return;
        }
        if (index == S.length || sum > target) {
            return;
        }

        // Include current element
        findSubsetsfunc(S, index + 1, sum + S[index], target, subset + S[index] + " ");

        // Exclude current element
        findSubsetsfunc(S, index + 1, sum, target, subset);
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 5, 6, 8};
        int d = 9;

        System.out.println("Subsets that sum to " + d + ":");
        findSubsetsfunc(S, 0, 0, d, "");
    }
}
