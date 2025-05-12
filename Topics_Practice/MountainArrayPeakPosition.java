
// Q : FIND PEAK POSITION & VALUE OF AN MOUNTAIN ARRAY
public class MountainArrayPeakPosition {

    static int searchElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }
        return arr[end]; // THIS WILL RETURN THE VALUE OF PEAK OF MOUNTAIN ARRAY
//        return end; // THIS WILL RETURN THE INDEX OF PEAK OF MOUNTAIN ARRAY
    }

    public static void main(String[] args) {
        int[] num = {1, 4, 7, 9, 3, 2, 1, 0};
        int ans = searchElement(num);
        System.out.println(ans);
    }
}
