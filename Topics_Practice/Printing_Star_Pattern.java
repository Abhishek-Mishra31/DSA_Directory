public class Printing_Star_Pattern {


    // question was print the pattern looks like this :--
//                   *****
//                   ****
//                   ***
//                   **
//                   *
    static void pattern1(int n) {
        for (int row = n; row > 0; row--) {
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // question was print the pattern looks like this :-
//                         1
//                         12
//                         123
//                         1234
//                         12345
    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col); // col number is prints in this pattern
            }
            System.out.println();
        }
    }

    // next question was that print patters looks like this :-
//                                 *
//                                 **
//                                 ***
//                                 ****
//                                 ***
//                                 **
//                                 *

    static void pattern3(int n) {
        // we print this pattern using 2 ways
        //    1st way - using for loop 2 times

      /*  for (int row = 1; row < n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = n; row > 0; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();

       */


        // 2nd way is to update the value of colsInRow variable if the row value if greater than n

        for (int row = 1; row < 2 * n; row++) {
            int colsInRow = row > n ? 2 * n - row : row;
            for (int col = 1; col <= colsInRow; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        pattern1(5);
//        pattern2(5);
        pattern3(3);
    }
}
