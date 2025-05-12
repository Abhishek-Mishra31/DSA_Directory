
// Question  :- Search a element in 2D Array

import java.util.Arrays;

public class SearchIn2dArray {

    static int[] searchElement(int[][] arr, int target) {
        int row = 0;
        int col = arr.length;
        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return new int[]{row, col};
            } else if (arr[row][col] > target) {
                // move to next column of the array
                col--;
            } else {
                // move to next row of the array
                row++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        // as we know that num is a sorted 2d array so this binarySearch method works
        int[][] num = {
                {2, 4, 6, 8},
                {5, 10, 15, 20},
                {7, 12, 18, 24}
        };

        int[] ans = searchElement(num, 18);
        System.out.println(Arrays.toString(ans));
    }


}
