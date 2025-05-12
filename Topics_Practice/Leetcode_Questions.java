import java.util.Arrays;

public class Leetcode_Questions {

    // Question that : from a sorted array tell the numbers of elements without repetitive elements
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }


    // Question that : Remove Element( from user input value ) and give unique elements with numbers
    public static int removeElement(int[] num, int val) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != val) {
                num[count] = num[i];
                count++;
            }
        }

        return count;
    }

    // Question that : Return first occurrence of given string input from string
    public static int firstIndex(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Question that : Search in Rotated Sorted Array

    static public int getPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] <= nums[end]) {
            return start;
        }

        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int result = getPivot(nums);
        int mid = 0;
        while (start < end) {
            System.out.println("result is " + result);
            mid = start + (end - start) / 2;
            if (result == -1) {
                // JUST DO SIMPLE BINARY SEARCH
                return binarySearch(nums, 0, nums.length - 1, target);
            } else if (nums[result] == target) {
                return result;
            } else if (target >= nums[0]) {
                return binarySearch(nums, start, result + 1, target);
            } else {
                return binarySearch(nums, result - 1, end, target);
            }
        }
        return -1;
    }


    // Question that : find missing positive number
    // example = nums = [1,2,0]
    // Output = 3

    public static int missingPositive(int[] arr) {

        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                return j + 1;
            }
        }
        return arr.length + 1;
    }

    // Question that : find the first and last occurrence of given number
    //                 Example- num{5,7,7,8,8,10};
    // output should be : [3 , 4]

    public static int[] searchRange(int[] nums, int target) {
        System.out.println(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] == target && nums[j] == target) {
                    return new int[]{i, j};
                } else if (i == nums.length - 1 && nums[i] == target) {
                    return new int[]{i, i};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Question that :  Search Insert Position for given target
    // Example : nums = [1,3,5,6], target = 5
    //           Output: 2

    //    Input: nums = [1,3,5,6], target = 2
    //    Output: 1

    //    Input: nums = [1,3,5,6], target = 7
    //    Output: 4

    public static int searchInsert(int[] nums, int target) {
        int answer = 0;
        for (int i = 0; i <= nums.length -1 ; i++) {
            if (nums[i] == target) {
                answer =  i;
            } else if (nums[i] < target) {
                answer = i + 1;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr2 = {1, 1, 2};
        int[] arr3 = {1, 3, 4, 2, 2};
        int[] cyclicArr = {4, 5, 2, 3, 1};

//        System.out.println(removeDuplicates(arr)); // this will return 5 as number of unique element
//        System.out.println(removeDuplicates(arr2)); // this will return 2 as number of unique element
//        System.out.println(removeDuplicates(arr3)); // this will return 4 as number of unique element
//        System.out.println(removeDuplicates(cyclicArr)); // this will return 5 as number of unique element

        int[] nums = {3, 2, 2, 3};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(removeElement(nums, 3));
//        System.out.println(removeElement(nums2 , 2));

//        System.out.println(firstIndex("sadnotsad", "sad"));

        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        int[] array = {0};
        int[] array2 = {1, 3};
        int[] test = {1};
//        System.out.println(search(rotated, 7));
//        System.out.println(search(array, 0));
//        System.out.println(search(array2, 3));
//        System.out.println("pivot value is " + getPivot(array2));
//        System.out.println(search(test, 0));


        int[] cyclic = {7, 8, 9, 11, 12};
        int[] cyclic2 = {0, 2, 1};
        int[] cyclic3 = {3, 4, -1, 1};
//        System.out.println(missingPositive(cyclic));
//        System.out.println(missingPositive(cyclic2));
//        System.out.println(missingPositive(cyclic3));


        int[] searchArray = {5, 7, 7, 8, 8, 10};
        int[] test2 = {};
        int[] test3 = {1};

//        int[] result = searchRange(searchArray, 8);
//        int[] testResult = searchRange(test2, 0);
//        int[] test3Result = searchRange(test3, 1);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(testResult));
//        System.out.println(Arrays.toString(test3Result));

        int[] num = {1,3,5,6};
        System.out.println(num.length);
        System.out.println(searchInsert(num , 7));
    }
}


