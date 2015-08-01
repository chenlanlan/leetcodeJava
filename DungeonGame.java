public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) return 0;
        int n = dungeon[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 0: - dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dungeon[i][n - 1] >= dp[i + 1][n - 1] ? 0 : dp[i + 1][n - 1] - dungeon[i][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = dungeon[m - 1][j] >= dp[m - 1][j + 1] ? 0 : dp[m - 1][j + 1] - dungeon[m - 1][j];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = dungeon[i][j] >= dp[i + 1][j] ? 0 : dp[i + 1][j] - dungeon[i][j];
                int right = dungeon[i][j] >= dp[i][j + 1] ? 0 : dp[i][j + 1] - dungeon[i][j];
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0] + 1;
    }
    
    public static void main(String[] args) {
        DungeonGame test = new DungeonGame();
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(test.calculateMinimumHP(dungeon));
    }
}