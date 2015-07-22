import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet set1 = new HashSet();
        HashSet set2 = new HashSet();
        HashSet set3 = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (check(board[i][j], set1)) return false;
                if (check(board[j][i], set2)) return false;
            }
            set1.clear();
            set2.clear();
        }
        for (int i = 1; i < board.length; i = i + 3) {
            for (int j = 1; j < board.length; j = j + 3) {
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if (check(board[i + x][j + y], set3)) return false;
                    }
                }
                set3.clear();
            }
        }
        return true;
    }

    public boolean check(char c, HashSet set) {
        if (c != '.' && set.contains(c)) return true;
        set.add(c);
        return false;
    }

    public static void main(String[] args) {
        ValidSudoku test = new ValidSudoku();
        char[][] board = {{'1', '2', '3', '.', '.', '.', '.', '.', '.'},
                {'4', '5', '6', '.', '.', '.', '.', '.', '.'},
                {'7', '8', '9', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(test.isValidSudoku(board));
    }
}