public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (board.length * board[0].length < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean[][] check = new boolean[board.length][board[0].length];
                if (search(board, check, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean search(char[][] board, boolean[][] check, String s, int target, int row, int col) {
        if (target >= s.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (check[row][col]) {
            return false;
        }
        if (board[row][col] != s.charAt(target)) {
            return false;
        }
        check[row][col] = true;
        boolean result = search(board, check, s, target + 1, row + 1, col) || search(board, check, s, target + 1, row - 1, col) || search(board, check, s, target + 1, row, col + 1) ||search(board, check, s, target + 1, row, col - 1);
        if(result == false) {
            check[row][col] = false;
        }
        return result;
    }
}