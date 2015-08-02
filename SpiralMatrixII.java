public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        generate(n, 1, 0, 0, res);
        return res;
    }
    
    public int[][] generate(int n, int num, int x, int y, int[][] res) {
        if (n <= 0) return res;
        for (int i = 0; i < n; i++) {
            res[x][y + i] = num;
            num++;
        }
        for (int j = 1; j < n; j++) {
            res[x + j][y + n - 1] = num;
            num++;
        }
        if (n > 1) {
            for (int i = n - 2; i >= 0; i--) {
                res[x + n - 1][y + i] = num;
                num++;
            }
            for (int j = n - 2; j >= 1; j--) {
                res[x + j][y] = num;
                num++;
            }
        }
        return generate(n - 2, num, x + 1, y + 1, res);
    }
    
}