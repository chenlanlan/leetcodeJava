public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = getLiveNum(board, i, j);
                if (x == 2) {
                    continue;
                } else if (x == 3){
                    board[i][j] = board[i][j] == 0 ? 3 : 1;
                } else {
                    board[i][j] = board[i][j] == 1 ? 2 : 0;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
    
    private int getLiveNum(int[][] board, int x, int y) {
        int c = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || (i == x && j == y)) {
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == 2) c++;
            }
        }
        return c;
    }
}