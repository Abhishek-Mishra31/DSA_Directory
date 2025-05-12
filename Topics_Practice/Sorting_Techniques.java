import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorting_Techniques {

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Step 1: Assume the minimum element is the first element of the array
            int min = i;

            // Inner loop to find the minimum element in the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // Step 2: If the current element is smaller than the current minimum, update min
                    min = j;
                }
            }

            // Step 3: Swap the found minimum element with the first element of the array
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }


    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    static void insertionSort(int[] arr) {
//        The outer loop starts from the first element and iterates through to the second-to-last element
        for (int i = 0; i < arr.length - 1; i++) {
            // The inner loop starts from i + 1 and decrements j until it reaches the start of the array or until no further swaps are needed.
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    static void cycleSort(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1; // if we pass value this then we need to ensure that there is no 0 in our array , if it does then we error of INDEX OF BOUND EXCEPTION
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;

            }

        }
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = (arr.length / 2);
        int[] first = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeHelper(first, second);
    }


    static int[] mergeHelper(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }


        // if elements are remains then we need to copy it
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    // we implement the mergeSort according to space complexity , previous algorithm is not according to space complexity - in this case array object is created each time , so we implement a method for performing mergeSort algorithm according to space complexity
    static void mergeSort2(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort2(arr, start, mid);
        mergeSort2(arr, mid, end);

        mergeHelper2(arr, start, mid, end);
    }

    static void mergeHelper2(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // if elements are remains then we need to copy it
        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
//        int mid = start + (end - start) / 2;
        int randomIndex = low + (int) (Math.random() * (high - low + 1));

        int pivot = arr[low];

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

        // recursion calls for sort another two halves
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString((arr)));
    }

    public static void main(String[] args) {
        int[] arr = {64, 12, 25, 22, 11};
        int[] cyclicArr = {4, 3, 2, 5, 1};
        int[] quickArr = {4, 2, 1, 3, 5};
        int[] quickArr2 = {50, 70, 80, 30, 40, 88, 19, 27, 69};
//        printArray(arr);
//        selectionSort(arr);
//        bubbleSort(arr);
//        insertionSort(arr);
//        cycleSort(cyclicArr);
//        printArray(cyclicArr);
//        printArray(arr);
        int[] result = mergeSort(arr);
//        System.out.println(Arrays.toString(result));

        // second merge sort calling
//        System.out.println(Arrays.toString(arr));
//        mergeSort2(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("arrays before sorting: ");
        System.out.println(Arrays.toString(quickArr));
        System.out.println(Arrays.toString(quickArr2));
        quickSort(quickArr, 0, quickArr.length - 1);
        quickSort(quickArr2, 0, quickArr2.length - 1);

        System.out.println("arrays after sorting: ");
        System.out.println(Arrays.toString(quickArr));
        System.out.println(Arrays.toString(quickArr2));
        System.out.println();
    }

}
