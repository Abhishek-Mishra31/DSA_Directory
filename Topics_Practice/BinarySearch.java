public class BinarySearch {
    //  THE TIME - COMPELEXITY OF BINARY SEARCH IS O(logn) , please note that

    static int binarySearch(int[] num, int target) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < num[mid]) {
                end = mid - 1;
            } else if (target > num[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }


    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
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


    public static void main(String[] args) {
        int[] num = {12, 14, 16, 18, 20, 22};
        int[] num2 = {36, 24, 25, 15, 10, 8};
        int ans = binarySearch(num, 22);
        System.out.println(ans);


//        System.out.println(orderAgnosticBinarySearch(num , 20));
//        System.out.println(orderAgnosticBinarySearch(num2 , 25));

    }

}
