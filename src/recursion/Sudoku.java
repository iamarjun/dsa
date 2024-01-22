package recursion;

public class Sudoku {

    public static void main(String[] args) {

    }

    private static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '0'; k < '9'; k++) {
                        if (valid(i, j, k, board)) {
                            board[i][j] = k;

                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(int i, int j, char c, char[][] board) {
        for (int k = 0; k < board.length; k++) {
            // check row
            if (board[i][k] == c) {
                return false;
            }

            // check column
            if (board[k][j] == c) {
                return false;
            }

            
            //
            if (board[3 * (i / 3) + i / 3][3 * (j / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}