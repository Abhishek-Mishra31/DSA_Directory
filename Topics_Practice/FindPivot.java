public class FindPivot {

    static int getPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // 1st case
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // 2nd case
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return arr[mid - 1];
            }

            //3rd case
            if (arr[start] > arr[mid]) {
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
        int[] num = {5, 6, 7, 8, 9, 10, 31, 40, 1, 2, 3};
        int ans = getPivot(num);
        System.out.println(ans);
    }
}
