package CU_Practice_Programs;

import java.util.Arrays;

public class mergeSort {
    static void mergeSortFunc(int[] arr, int low, int high) {
        if (high - low == 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortFunc(arr, low, mid);
        mergeSortFunc(arr, mid, high);
        mergeHelper(arr, low, mid, high);
    }

    private static void mergeHelper(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int k = 0;
        int[] temp = new int[high - low];
        while (i < mid && j < high) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j < high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {30, 20, 40, 50, 10};
        int[] arr2 = {1, 7, 3, 5 };
        int[] arr3 = {50, 70, 80, 30, 40, 88, 19, 27, 69};

        System.out.println("array before sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        mergeSortFunc(arr, 0, arr.length);
        mergeSortFunc(arr2, 0, arr2.length);
        mergeSortFunc(arr3, 0, arr3.length);
        System.out.println("array after sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
