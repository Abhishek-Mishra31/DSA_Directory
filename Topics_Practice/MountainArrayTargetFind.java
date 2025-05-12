
//Q : FIND THE TARGET ELEMENT GIVEN BY AN USER IN A MOUNTAIN OR BITONIC ARRAY

import java.util.Arrays;

public class MountainArrayTargetFind {

    static int peakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] num = {10, 20, 30, 40, 50, 30, 15, 10, 5};
        int ans = peakElement(num);
        System.out.println(ans);
    }
}


// ONE MORE QUESTION IN THIS SERIES IN WHICH WE USE PEAKELEMENT() METHOD TO GET PEAK AND ORDERAGNOSTIC METHOD IN WHICH WE CHECK IF GIVEN ARRAY IS SORTED BY ASCENDING AND DECENDING ORDER AND THEN CALCULATE INDEX OF PEAK ELEMENT
