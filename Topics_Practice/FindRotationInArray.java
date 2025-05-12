public class FindRotationInArray {

    static int FindPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }
            if (start > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int getResult(int[] arr) {
        int pivot = FindPivot(arr);
        return pivot + 1;
    }

    public static void main(String[] args) {
        int[] num = {2, 4, 5, 6, 10, 1};
        System.out.println("This Array Will Rotate " + getResult(num) + " Times");
    }
}
