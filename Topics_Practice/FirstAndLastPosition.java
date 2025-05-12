

import java.util.Arrays;
public class FirstAndLastPosition {

    static int search(int[] num, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = num.length - 1 ;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < num[mid]) {
                end = mid - 1;
            } else if (target > num[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 5, 5};
        int target = 1;
        int[] ans = {-1,-1};

        // First Occurrence of element is found by below code
        ans[0] = search(nums, target, true);

        // last position of element is found by below code
        ans[1] = search(nums, target, false);
        System.out.println(Arrays.toString(ans));
    }
}
