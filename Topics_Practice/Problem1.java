
// problem is : count the digits presents in an array and tell the number of digits are even
//              you can use Seperate methods for count and checkEven()
//              great!

import java.util.Arrays;

public class Problem1 {

    // function to count digits in number
    static int countDigit(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    // function to count total number of elements which digits are even
    static int checkEven(int[] arr) {
        int evenCount = 0;
        for (int num : arr) {
            int result = countDigit(num);
            if (result % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }


    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 4};
        System.out.println(checkEven(nums));
        //System.out.println(Arrays.toString(num));// THIS LINE WILL PRINT ARRAY WITH WITH BRACEKETS []

    }
}
