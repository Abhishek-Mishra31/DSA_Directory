package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.List;

// Leetcode question no 78 - index out of bound exception
public class Subset_Problem {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, result);
        return result;
    }


    private static void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));

        }
        subset.add(nums[i]);
        helper(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        helper(nums, i + 1, subset, res);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> answer = subsets(nums);

    }
}
