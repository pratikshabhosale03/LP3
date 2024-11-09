import java.util.Scanner;

public class nqueen {
    
    private static boolean foundSolution = false;

    private static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;

        // Check column for any queen in the same column above this row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    private static void solveNQueens(int[][] board, int row) {
        int n = board.length;

        // If all queens are placed, print the solution
        if (row == n) {
            printBoard(board);
           foundSolution = true;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)  && !foundSolution) {
                board[row][col] = 1;  // Place queen !foundSolution

                // Recursive call for the next row
                solveNQueens(board, row + 1);

                // Backtrack if no solution found in this placement
                board[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the board (n): ");
        int n = scanner.nextInt();

        int[][] board = new int[n][n];
        System.out.println("solution for " + n + "-Queens problem:");
        
        solveNQueens(board, 0);  // Start solving from row 0

        scanner.close();
    }
}
