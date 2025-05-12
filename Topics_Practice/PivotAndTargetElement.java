public class PivotAndTargetElement {
    static int binarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];
        if (isAsc) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target > arr[mid]) {
                    start = mid + 1;
                } else if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }

        if (!isAsc) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    static int search(int[] arr, int target) {
        int pivot = getPivot(arr);

        if (pivot == -1) {
            // JUST DO SIMPLE BINARY SEARCH
            return binarySearch(arr, target, 0, arr.length - 1);

        } else if (arr[pivot] == target) {
            return pivot;

        } else if (target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot - 1);
        }
        else {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
    }

    static int getPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // 1st case
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            }
            //2nd case
            else if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            //3rd case
            else if (arr[start] > arr[mid]) {
                end = mid - 1;
            }
            //4th case
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] num = {5, 6, 7, 8, 9, 10, 31, 1, 2, 3};
        int target = 8;
        int result = search(num, target);
        System.out.println(result);
    }
}
