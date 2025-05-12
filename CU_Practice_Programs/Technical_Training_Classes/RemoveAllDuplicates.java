package CU_Practice_Programs.Technical_Training_Classes;

import java.util.Arrays;

public class RemoveAllDuplicates {

    // we need to remove the duplicates using function
    public static void removeDuplicates(int[] arr) {
        int length = arr.length;
        int[] tempArr = new int[length];
        int index = 0;

        // for sorting the array
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        tempArr[index] = arr[0];
        System.out.println(Arrays.toString(arr));
        for (int k = 1; k < length; k++) {
            if (arr[k] != arr[k - 1]) {
                index++;
                tempArr[index] = arr[k];
            } else if (arr[k] == arr[k - 1]) {
                System.out.print("the duplicates values are " + arr[k]);
                System.out.println();
            }
        }

        int[] output = Arrays.copyOf(tempArr, index + 1);
        System.out.println(Arrays.toString(output));
    }

//    static void func(int[] arr){
//        int i1 = arr.length - 1;
//        for (int i = 0; i < i1; i++) {
//            for (int j = 0; j < i1; j++) {
//                if(arr[i] == arr[j]){
//                    int z = j;
//                    while (z <= i1){
//                        arr[j] = arr[j+1];
//                        z++;
//                    }
//                    i1--;
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
        int[] array = {64, 20, 9, 74, 2, 99, 43, 9, 53, 41, 43, 64, 89, 19, 19};
        System.out.println(Arrays.toString(array));
//        func(array);
        removeDuplicates(array);
    }
}
