public class PivotInDuplicateArray {
    static int findPivotInDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 1st Case
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            // 2nd Case
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return arr[mid - 1];
            }
            // 3rd Case
            // Check if start and end is pivot element or not
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {

                if (arr[start] > arr[start + 1]) {
                    return arr[start];
                }
                start++;
                if (arr[end] < arr[end - 1]) {
                    return arr[end - 1];
                }
                end--;
                // Left side is sorted now the turn of right one
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && (arr[end] < arr[mid]))) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 6, 7, 7, 8, 8, 9, 1, 2, 2, 2, 3};
        int ans = findPivotInDuplicate(arr);
        System.out.println(ans);
    }

}
