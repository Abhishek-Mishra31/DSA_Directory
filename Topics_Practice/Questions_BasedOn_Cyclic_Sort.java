import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions_BasedOn_Cyclic_Sort {

    // question was that find missingnumber in an given array
    static int findMissingNumber(int[] arr) {
        // we use for loop to perform the cyclic sort method
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        // we need to implement a logic when a element is missing on its index then it returns the element
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return arr.length;
    }

    // the question was to find all missing numbers in duplicate array so we implemented List and Arraylist interface to solve this problem , if the array is not duplicate then we initially sort the array using cyclic sort and then we create a arraylist to store elements which is missing in this array ! simple
    static List<Integer> findAllMissingNumbers(int[] arr) {
        // for loop for sort this array using cyclic sort
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        // we implement logic for missing numbers
        List<Integer> answer = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                answer.add(j + 1);
            }
        }
        return answer;
    }

    // the question was that find the repetitive ( duplicate )  number in given array
    static int findDuplicateElement(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        // implement logic to get repetitive number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return arr[index];
            }
        }

        return -1;
    }

    // question was that find all duplicates elements in given array
    static List<Integer> findAllDuplicateElements(int[] arr) {
        //  for loop for sort the given array
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];;
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        // logic for find repetitive elements in array
        List<Integer> answer = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                answer.add(arr[j]); // we are returning arr[j] bcz when element is not present in given condition then return itself
            }
        }
        return answer;
    }

    // the question was that at first find the number which is repeated and second missing number in the form of array
    static int[] findSetMismatch(int[] arr) {

        // we sort the array using the cyclic sort
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        // we implement the logic to find the repetitive and missing number in the form of array
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return new int[]{arr[index], index + 1};
            }
        }
        return new int[]{-1, -1};
    }

    // question was find the first missing positive number in the given array
    static int missingPositiveNumber(int[] arr) {
        // we sort the given array using the cyclic sort
        for (int i = 0; i < arr.length; ) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        // implement a logic for find the missing first positive number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }
        return arr.length + 1;
    }


    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        int[] allArr = {4, 3, 2, 7, 8, 2, 3, 1, 7};
        int[] duplicateArr = {1, 3, 3, 2, 4, 2};
        int[] setArr = {4, 2, 3, 3, 1, 6};
//        printArray(arr);

//        int missNum = findMissingNumber(arr);
//        System.out.println(missNum + " is missed in this array");

//        List<Integer> MissingNumbers = findAllMissingNumbers(allArr);
//        System.out.println(MissingNumbers);
//        printArray(duplicateArr);

//        int duplicateNumber = findDuplicateElement(duplicateArr);
//        System.out.println(duplicateNumber);

//        printArray(duplicateArr);
//        List<Integer> duplicateNumbers = findAllDuplicateElements(allArr);
//        System.out.println(duplicateNumbers);


//        printArray(setArr);
//        int[] setMisMatch = findSetMismatch(setArr);
//        System.out.println("{" + setMisMatch[0] + ", " + setMisMatch[1] + "}");

        printArray(arr);
        int result = missingPositiveNumber(arr);
        System.out.println(result);
    }
}
