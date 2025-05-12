// QUESTION :- Find position of an element in a sorted array of infinite numbers


public class ElementInInfiniteArray {

    static int BinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int searchElement(int[] num, int target) {
        int start = 0;
        int end = 1;
        // check if target is found in range
        while (target > num[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        // we update the value of start and end every time before passing to BinarySearch() method
        return BinarySearch(num, target, start, end);

    }

    public static void main(String[] args) {
        int[] num = {10, 30, 50, 70, 90, 110, 130, 150, 170, 190, 210 , 230 ,250 , 270};
        int target = 270;
        int ans = searchElement(num, target);
        System.out.println(ans);
    }
}
