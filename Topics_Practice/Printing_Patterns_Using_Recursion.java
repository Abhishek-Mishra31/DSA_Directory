import java.lang.reflect.Array;
import java.util.Arrays;

public class Printing_Patterns_Using_Recursion {

    // Question :-  print this pattern given below using Recursion

    //                                            ****
//                                                ***
//                                                **
//                                                *
    static void printPattern1(int row, int col) {
        // Base case: if row is 0, stop the recursion
        if (row == 0) {
            return;
        }

        // If col is less than the current row, print a star and recurse with the next column
        if (col < row) {
            System.out.print("*");
            printPattern1(row, col + 1);

        } else {
            // If col is not less than the current row, print a newline and recurse with the next row
            System.out.println();
            printPattern1(row - 1, 0);
        }
    }


    // question 2 :- Print this patten using recursion
//                                        *
//                                        **
//                                        ***
//                                        ****

    static void printPattern2(int row, int col) {
        // Base case: if row is 0, stop the recursion
        if (row == 0) {
            return;
        }
        // If col is less than the current row, recurse with the next column and then print a star
        if (col < row) {
            printPattern2(row, col + 1);
            System.out.print("*");
        } else {
            // If col is not less than the current row, recurse with the next row and print a newline
            printPattern2(row - 1, 0);
            System.out.println();
        }
    }

    // Question 3 :- Write a recursive function for bubble sort
    // example = [ 4 ,3 ,2 , 1 ];
    // output = [ 1 , 2 , 3, 4 ];

    static void bubbleSort(int[] arr, int length) {
        if (length == 1) {
            return;
        }

        // Logic for Swapping values in given array
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // recursive call
        bubbleSort(arr, length - 1);
    }

    // Question 4 :- write the recursive function for selection sort
    // example :- arr = { 4 , 2 , 3 , 1 };
    // Output :- { 1 , 2 , 3 , 4 };
    static void selection(int[] arr, int index, int n) {
        // base case: when only one element is left
        if (index == n - 1) {
            return;
        }


        // Find the index of the minimum element from index to end
        int minIndex = index;
        for (int i = index + 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Swap the found minimum element with the element at the starting index
        int temp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = temp;

        // Recursive call for the rest of the array
        selection(arr, index + 1, n);
    }


    public static void main(String[] args) {
//        printPattern1(4, 0);
//        printPattern2(4, 0);
        int[] arr = {2, 4, 3, 1};
//        bubbleSort(arr, arr.length);
//        System.out.println(Arrays.toString(arr));
        System.out.println("after selection sort array looks like :- ");
        selection(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

}
