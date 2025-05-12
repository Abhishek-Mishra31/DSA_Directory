public class Recursion_Question {

    // question 1 :- Write a recursive program for find sum of digits of given number
    // example :- int n = 1082
    // output :- 11
    static int sumDigits(int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumDigits(n / 10) + n % 10;
        }
    }

    // question 2 :- Write a recursive program for find product of its digits of given number
    // example :- int n = 544
    // output :- 80
    static int productDigit(int n) {
        if (n == 0) {
            return 1;
        } else {
            return productDigit(n / 10) * (n % 10);
        }
    }

    // question 2 :- reverse a given number using recursion
    // example :- 1234
    // Output :- 4321
    static int rev = 0;

    static void reverseNumber(int n) {

        if (n == 0) {
            return;
        } else {
            int rem = n % 10;
            rev = (rev * 10) + rem;
            reverseNumber(n / 10);
        }
    }

    // question 3 :- check given number is palindrome or not
    // example :- 1001
    // output :- true
    static boolean isPalindrome(int n) {
        return n == rev;
    }

    // question 4 :- count all the zeroes available in given number
    // example :- 11001
    // output :- 2
    static int getCount(int n) {
        if (n == 0) {
            return 1;
        }
        return helper(n, 0);
    }

    static int helper(int n, int count) {
        if (n == 0) {
            return count;
        }

        if (n % 10 == 0) {
            return helper(n / 10, count + 1);
        }
        return helper(n / 10, count);
    }

    // question is :- return the number of steps until given number is not zero , if current number is even then divide it by 2 and when odd then subtract it 1 from it
    // example = 14
    // output = 6 -> this mean to say that there are totally 6 steps require to number became 0;

    static int getSteps(int n) {
        return helperSteps(n, 0);
    }

    static int helperSteps(int n, int steps) {
        if (n == 0) {
            return steps;
        }
        if (n % 2 == 0) {
            return helperSteps(n / 2, steps + 1);
        }
        return helperSteps(n - 1, steps + 1);
    }

    // Question was that find fibonacci number at nth element
    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    // Question was that implement binary search algorithm using recursion
    static int BinarySearchUsingRecursion(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (arr[mid] > target) {
            return BinarySearchUsingRecursion(arr, target, start, mid - 1);
        } else {
            return BinarySearchUsingRecursion(arr, target, mid + 1, end);
        }
    }

    // Question is check whether given array is sorted or not
    static boolean isSorted(int arr[], int index) {
        // base condition
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);

    }

    // Question is search given element in an array
    static int search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return search(arr, target, index + 1);
        }
    }

    // Question is search an element in a rotated array using binary search
    static int searchBinary(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        // we check if mid-element is target or not
        if (arr[mid] == target) {
            return mid;
        }

        // we check the given 1st half is sorted or not and target is available in or not
        if (arr[start] <= arr[mid]) {
            if (target>= arr[start] && target <= arr[mid]) {
                return searchBinary(arr, target, start, mid - 1);
            } else {
                return searchBinary(arr, target, mid + 1, end);
            }
        }

        // we check if second half is sorted and target is available in it or not
        if (target >= arr[mid] && target <= arr[end]) {
            return searchBinary(arr, target, mid + 1, end);
        }
            return searchBinary(arr, target, start, mid - 1);
    }


    public static void main(String[] args) {
        // sumDigit result here
        int number = 1082;
//        System.out.println(sumDigits(number));

        // productDigit result here
        int productResult = 250;
//        System.out.println(productDigit(productResult));

        // reverse a number
        int reverse = 1001;
        reverseNumber(reverse);
//        System.out.println(rev);

        // check if number is palindrome or not
//        System.out.println(isPalindrome(reverse));

        // get all zeroes in given number
        int num = 1400500360;
//        System.out.println(getCount(num));

        // get steps for given number became zero
        int input = 40;
//        System.out.println(getSteps(input));

        // binary search using recursion
        int[] arr = {11, 22, 44, 55, 66};
        int result = BinarySearchUsingRecursion(arr, 55, 0, arr.length - 1);
//        System.out.println(result);

        // check whether a array is sorted or not
//        System.out.println(isSorted(arr, 0));

        // search a element in a given array
//        System.out.println(search(arr, 11, 0));

        // search an element in rotated array using binarySearch
        int[] nums = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(searchBinary(nums, 5, 0, nums.length - 1));

    }
}
