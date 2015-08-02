public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length;
        if (rows == 0) return res;
        int cols = matrix[0].length;
        if (cols == 0) return res;
        spiralHelper(matrix, rows, cols, 0, 0, res);
        return res;
    }
    
    public List<Integer> spiralHelper(int[][] matrix, int rows, int cols, int x, int y, List<Integer> res) {
        if (rows <= 0 || cols <= 0) return res;
        for (int i = 0; i < cols; i++) {
            res.add(matrix[x][y + i]);
        }
        for (int j = 1; j < rows; j++) {
            res.add(matrix[x + j][y + cols - 1]);
        }
        if (rows > 1) {
            for (int i = cols - 2; i >= 0; i--) {
                res.add(matrix[x + rows - 1][y + i]);
            }
        }
        if (cols > 1) {
            for (int j = rows - 2; j >= 1; j--) {
                res.add(matrix[x + j][y]);
            }
        }
        return spiralHelper(matrix, rows - 2, cols - 2, x + 1, y + 1, res);
    }
    
}