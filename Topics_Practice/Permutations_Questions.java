package Topics_Practice;

public class Permutations_Questions {

    // problem 1 : Letter combination of a phone number
    static void phoneNumber(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        // Get the first digit from 'up' and convert it from char to int
        int digit = up.charAt(0) - '0'; // this will convert '2' to 2

        // Calculate the range of letters corresponding to the current digit
        // The digit '1' corresponds to letters 'a', 'b', 'c', '2' to 'd', 'e', 'f', and so on.
        // For example, if digit = 1, loop will iterate over 'a', 'b', 'c'.
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            // Recursive call: add the current letter 'ch' to the prefix 'p',
            phoneNumber(p + ch, up.substring(1));
        }
    }

    // problem 2 :- prints all ways to show 4 on a dice
    // the recursive calling tree helps with this question to find way to show 4 on a dice

    //    diceProblem("", 4)
    //├── diceProblem("1", 3)
    //│   ├── diceProblem("11", 2)
    //│   │   ├── diceProblem("111", 1)
    //│   │   │   ├── diceProblem("1111", 0)   // Prints "1111"
    //│   │   ├── diceProblem("112", 0)        // Prints "112"
    //│   ├── diceProblem("12", 1)
    //│   │   ├── diceProblem("121", 0)        // Prints "121"
    //│   ├── diceProblem("13", 0)             // Prints "13"
    //├── diceProblem("2", 2)
    //│   ├── diceProblem("21", 1)
    //│   │   ├── diceProblem("211", 0)        // Prints "211"
    //│   ├── diceProblem("22", 0)             // Prints "22"
    //├── diceProblem("3", 1)
    //│   ├── diceProblem("31", 0)             // Prints "31"
    //├── diceProblem("4", 0)                  // Prints "4"

    static void diceProblem(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            diceProblem(p + i, target - i);
        }
    }

    // Problem 3 :-
    //    Given an R * C matrix representing a maze, the rat starts at the top-left cell (m[0][0]) and must reach the bottom-right cell (m[R-1][C-1]). The rat can only move right (→) or down (↓) to adjacent cells. The task is to find the path for the rat from the source to the destination.
    static void pathsPrints(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }

        if (row > 1) {
            pathsPrints(p + "D", row - 1, col);
        }

        if (col > 1) {
            pathsPrints(p + "R", row, col - 1);
        }
    }

    // if we want diagonal way to reach the destination then we can do like this :-
    static void pathsDiagonal(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }

        if (row > 1) {
            pathsDiagonal(p + "V", row - 1, col);
        }
        if (row > 1 && col > 1) {
            pathsDiagonal(p + "D", row - 1, col - 1);
        }
        if (col > 1) {
            pathsDiagonal(p + "H", row, col - 1);
        }
    }

    // here's we access full paths through an array not by given row & col
    static void fullPaths(String p, boolean[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!arr[row][col]) {
            return;
        }

        arr[row][col] = false;

        if (row < arr.length - 1) {
            fullPaths(p + "D", arr, row + 1, col);
        }

        if (row > 0) {
            fullPaths(p + "U", arr, row - 1, col);
        }

        if (col > 0) {
            fullPaths(p + "L", arr, row, col - 1);
        }

        if (col < arr[0].length - 1) {
            fullPaths(p + "R", arr, row, col + 1);
        }

        arr[row][col] = true;
    }

    public static void main(String[] args) {
//        phoneNumber("", "12");
//        diceProblem("", 4);
//        pathsPrints("", 3, 3);
//        pathsDiagonal("", 3, 3);
        boolean[][] nums = {{true, true, true}, {true, true, true}, {true, true, true},};
        fullPaths("", nums, 0, 0);
    }
}