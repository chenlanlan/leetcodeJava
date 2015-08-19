public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j, matrix.length - i - 1, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j <=i ; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        return;
    }
    
    public void swap(int[][] matrix, int i, int j, int a, int b) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }
}