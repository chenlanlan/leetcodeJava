public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] d = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = matrix[i][j] - '0';
                if (i != 0 && j != 0 && d[i][j] != 0) {
                    d[i][j] = Math.min(d[i][j - 1], Math.min(d[i - 1][j], d[i - 1][j - 1])) + 1;
                }
                ans = Math.max(ans, d[i][j]);
            }
        }
        return ans * ans;
    }
    
}