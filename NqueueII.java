public class NqueueII {
    public int totalNQueens(int n) {
        int res = 0;
        int[] board = new int[n];
        res = solve(n, 0, res, board);
        return res;
    }
    
    public int solve(int n, int curRow, int res, int[] board) {
        if (curRow == n) {
            res++;
            return res;
        }
        for (int i = 0; i < n; i++) {
            boolean valid = true;
            for (int k = 0; k < curRow; k++) {
                if (board[k] == i) {
                    valid = false;
                    break;
                }
                if (Math.abs(board[k] - i) == curRow - k) {
                    valid = false;
                    break;
                }
            }
            if (valid == true) {
                board[curRow] = i;
                res = solve(n, curRow + 1, res, board);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        NqueueII test = new NqueueII();
        System.out.println(test.totalNQueens(1));
    }
}