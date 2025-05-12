
// Question :- Split the given array and return the subarray which is maximum sum of its elements

public class SplitArray {

    static int findSubarray(int[] arr, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            // we assign the largest value of this array in start variable
            start = Math.max(start, arr[i]);
            // and we assign the total sum of elements of array in end variable
            end += arr[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for (int num : arr) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] num = {7, 2, 5, 10, 8};
        int ans = findSubarray(num, 2);
        System.out.println(ans);
    }
}
