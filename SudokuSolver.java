public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        internalSolveSudoku(board);
        return;
    }

    public boolean internalSolveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                    for (char chr : chars) {
                        board[i][j] = chr;
                        if (isValidSudoku(board, i, j) && internalSolveSudoku(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
    }

    return true;
}

    public boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (x != i && board[i][y] == board[x][y]) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (y != i && board[x][i] == board[x][y]) return false;
        }
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (x != i && y != j && board[i][j] == board[x][y]) return false;
            }
        }
        return true;
    }
}