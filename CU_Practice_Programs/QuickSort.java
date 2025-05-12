package CU_Practice_Programs;

import java.util.Arrays;

// this works only when we assign pivot value is first element !
public class QuickSort {
//    static int partiton(int[] arr, int p, int q) {
//        int pivot = p;
//        int i = p;
//
//        for (int j = p + 1; j <= q; j++) {
//            if (arr[j] <= arr[pivot]) {
//                i = i + 1;
//                swap(arr, i, j);
//            }
//        }
//
//        swap(arr, p, i);
//        return i;
//    }
//
//    static void quickSort(int[] arr, int low, int high) {
//        if (low > high) {
//            return;
//        }
//        int m = partiton(arr, low, high);
//        quickSort(arr, low, m - 1);
//        quickSort(arr, m + 1, high);
//    }
//
//    static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    static void QuickSort2(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
//        int randomIndex = low + (int) (Math.random() * (high - low + 1));

//        int pivot = arr[low];
        int pivot = arr[mid];

        while (start < end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        QuickSort2(arr, low, end);
        QuickSort2(arr, start, high);
    }

    public static void main(String[] args) {
        int[] input = {7,8,2,3,9};

        System.out.println(Arrays.toString(input));
        QuickSort2(input , 0 , input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}

