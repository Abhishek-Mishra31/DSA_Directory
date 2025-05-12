import java.util.Arrays;

public class Reverse_Array {

//    Question was that flipping the image
//                example if arr given like this :- int [][] arr = [[1,1,0] , [1,0,1] , [0,0,0]]
//                Output = [[1,0,0] , [0,1,0] , [1,1,1]]

//                Solution :- first we reverse the row like this :- [[0,1,1] , [1,0,1] , [0,0,0]]
//                            then we revert this by using bitwise XOR with 1 as we know if we operate bitwise XOR with 1 with                             any number then it returns the compliment of that number

    static int[][] flippsImage(int[][] arr) {
        for (int[] row : arr) {
            for (int i = 0; i < (arr[0].length + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[arr[0].length - 1 - i] ^ 1;
                row[arr[0].length - 1 - i] = temp;
            }
        }
        return arr;
    }

    static void reverseArray(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }


    static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int nums[] = {5, 4, 3, 2};
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};


//        printArray(nums);
//        reverseArray(nums);
        System.out.println(Arrays.deepToString(image));
        System.out.println(Arrays.deepToString(flippsImage(image)));

        // Print the 2D array using Arrays.deepToString()
//        System.out.println(Arrays.deepToString(image));
    }

}
