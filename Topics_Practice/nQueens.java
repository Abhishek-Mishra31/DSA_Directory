public class nQueens {

    public static int Queens(boolean[][] board, int row) {
        if (row == board.length) {
            displayQueens(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += Queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }


    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row first
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // we check left diagonal for placing queens
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - 1][col - 1]) {
                return false;
            }
        }

        // we check right diagonal for placing queens
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - 1][col + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void displayQueens(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(Queens(board, 0));
    }
}
