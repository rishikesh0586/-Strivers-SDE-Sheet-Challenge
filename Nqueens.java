import java.util.ArrayList;

class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    static void solve(int col, int[][] board, ArrayList<ArrayList<Integer>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 1;
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = 0;
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    static ArrayList<Integer> construct(int[][] board) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int[] row : board) {
            for (int i : row) {
                solution.add(i);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int N = 4;
        ArrayList<ArrayList<Integer>> queens = solveNQueens(N);
        int i = 1;
        for (ArrayList<Integer> solution : queens) {
            System.out.println("Arrangement " + i);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (solution.get(j * N + k) == 1) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            i++;
        }
    }
}
