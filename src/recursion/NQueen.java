package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        var result = solveNQueen(4);
        System.out.println(result);
    }

    private static List<List<String>> solveNQueen(int n) {
        var board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '*';
            }
        }

        var result = new ArrayList<List<String>>();
        var leftRow = new int[n];
        var uppperDiagonal = new int[2 * n - 1];
        var lowerDiagonal = new int[2 * n - 1];
        dfs(board, 0, result, leftRow, uppperDiagonal, lowerDiagonal);
        return result;
    }

    private static void dfs(char[][] board, int col, ArrayList<List<String>> result, int[] leftRow,
            int[] uppperDiagonal, int[] lowerDiagonal) {
        if (col == board.length) {
            result.add(constructBoard(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] != 1 && uppperDiagonal[board.length - 1 + col - row] != 1
                    && lowerDiagonal[row + col] != 1) {

                board[row][col] = 'Q'; // add queen
                leftRow[row] = 1;
                uppperDiagonal[board.length - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;
                dfs(board, col + 1, result, leftRow, uppperDiagonal, lowerDiagonal);
                board[row][col] = '*'; // reset queen
                leftRow[row] = 0;
                uppperDiagonal[board.length - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }

    private static List<String> constructBoard(char[][] board) {
        var list = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            var s = new String(board[i]);
            list.add(s);
        }
        return list;
    }

    private static boolean validQueenPlacement(int row, int col, char[][] board) {
        var _row = row;
        var _col = col;

        // upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = _row;
        col = _col;

        // left
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = _row;
        col = _col;

        // lower diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row++;
        }

        return true;
    }

}
