public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                ans += 1;
                dfs(i, m, j, n, grid);
            }
        }
        return ans;
    }
    
    public void dfs(int i, int m, int j, int n, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(i - 1, m, j, n, grid);
            dfs(i + 1, m, j, n, grid);
            dfs(i, m, j - 1, n, grid);
            dfs(i, m, j + 1, n, grid);
        }
    }
    
    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        char[][] grid = {{'1', '1', '0', '0', '0'},{'1', '1', '0', '0', '0'},{'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}};
        System.out.println(test.numIslands(grid));
    }
}