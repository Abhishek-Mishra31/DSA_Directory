package Topics_Practice;

public class NumberSystemBasedQuestions {

    static boolean isEven(int number) {
        // this line of code performs a bitwise AND operation between the number and 1 if LSB performs a bitwise AND operation between the number and 1.ast significant bit is 1 then number will be odd otherwise true
        return (number & 1) != 1;
    }


    // Question was that find the unique number (which comes only one times in given array)
    static int findUnique(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }


//     Question was that find the magic number of given number
//        example n = 6;
//         then we write 6 as - 1 1 0 and finding magic number like this 1 * 5^3 + 1 * 5^2 + 0 * 5*1 = 150
//       for this we created a function for this question's solution

    static int findMagicNumber(int n) {
        int base = 5;
        int answer = 0;
        while (n > 0) {
            int lastBit = n & 1;
            n = n >> 1;
            answer += lastBit * base;
            base = base * 5;
        }
        return answer;
    }

    // Question was that find xor of numbers from 0 to n , where n is a given number
    static void findXorNumbers(int n) {
        int cummulativeXor = 0;
        for (int i = 0; i < n; i++) {
            cummulativeXor ^= i;
            System.out.println("xor value for " + i + " is " + cummulativeXor);
        }
    }

    // if question was find the xor value of given specific number then we use this method
    static int findSpecificXorValue(int n) {
        // we check all these condition for get xor value
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int number = 2;
//        System.out.println(isEven(number));
        int[] nums = {6, 4, 2, 4, 2};
//        System.out.println(findUnique(nums));
        int magicNum = 6;
//        System.out.println(findMagicNumber(magicNum));
        ;
        findXorNumbers(10);
        System.out.println(findSpecificXorValue(3));
    }
}
