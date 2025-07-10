package Domain_Camp_Questions;

import java.util.Arrays;

// missing number from the given array
public class Day_1 {
    static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                return j + 1;
            }
        }
        return arr.length;
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 5, 1};
        int[] arr2 = {2, -3, 4, 1, 1, 7};
        int result = missingNumber(arr);
        int result2 = missingNumber(arr2);
        System.out.println(result);
        System.out.println(result2);

    }
}
