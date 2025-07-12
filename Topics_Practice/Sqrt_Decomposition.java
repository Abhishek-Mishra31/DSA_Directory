package Topics_Practice;

import java.util.Arrays;

public class Sqrt_Decomposition {
    // now we have to create a method to find the sum of all elements with given index value
    public static int findSum(int[] arr, int[] block, int l, int r, int sqrt) {
        int ans = 0;
        // we defined for left part
        while (l % sqrt != 0 && l < r && l != 0) {
            ans += arr[l]; // we added single element into answer
            l++;
        }

        // we defined the middle part
        while (l + sqrt <= r) {
            ans += block[l / sqrt]; // we added whole block elements into answer
            l += sqrt;
        }

        // we defined the right part
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    public static void updateValue(int[] arr, int[] block, int l, int newValue, int sqrt) {
        int block_id = l / sqrt;
        block[block_id] += (newValue - arr[l]);
        arr[l] = newValue;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 6, 1, 3, 5, 7};

        int sqrt = (int) Math.sqrt(arr.length);

        // creating a block array to update all of its element sum
        int[] blocks = new int[sqrt + 1];
        int block_id = -1;

        for (int i = 0; i < arr.length; i++) {
            if (i % sqrt == 0) {
                block_id++;
            }

            blocks[block_id] += arr[i];
        }

        System.out.println(Arrays.toString(blocks));

        System.out.println("the sum of index 2 to 4 elements is " + findSum(arr, blocks, 2, 4, sqrt));
        updateValue(arr, blocks, 2, 4, sqrt);
        System.out.println("Modified array is ");
        System.out.println(Arrays.toString(blocks));
    }
}
