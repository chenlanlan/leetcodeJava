public class LongestIncreasingContinuousSubsequenceII {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        int res = 0;
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int[][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (dp[i][j] == 0) {
                    res = Math.max(res, dfs(A, dp, i, j));
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] A, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int left = 0, right = 0, up = 0, down = 0;
        if (j + 1 < A[0].length && A[i][j + 1] > A[i][j]) {
            right = dfs(A, dp, i, j + 1);
        }
        if (j - 1 >= 0 && A[i][j - 1] > A[i][j]) {
            left = dfs(A, dp, i, j - 1);
        }
        if (i + 1 < A.length && A[i + 1][j] > A[i][j]) {
            down = dfs(A, dp, i + 1, j);
        }
        if (i - 1 >= 0 && A[i - 1][j] > A[i][j]) {
            up = dfs(A, dp, i - 1, j);
        }
        dp[i][j] = Math.max(Math.max(left, right), Math.max(up, down)) + 1;
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        LongestIncreasingContinuousSubsequenceII test = new LongestIncreasingContinuousSubsequenceII();
        int[][] A = {{1, 2}, {4, 3}};
        test.longestIncreasingContinuousSubsequenceII(A);
    }
}