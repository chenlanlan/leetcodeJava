public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            if (matrix[r][c] == target) return true;
            if (matrix[r][c] > target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        SearchA2DMatrix test = new SearchA2DMatrix();
        int[][] matrix = {{1, 3, 5}, {6, 7, 8}};
        System.out.println(test.searchMatrix(matrix, 6));
    }
}