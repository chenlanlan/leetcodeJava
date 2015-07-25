public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k >= prices.length) return maxProfit2(prices);
        int[] global = new int[k + 1];
        int[] local = new int[k + 1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    public int maxProfit2(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - min;
                min = prices[i];
            }
        }
        profit += prices[prices.length - 1] - min;
        return profit;
    }
    
    public int maxProfitSolution2(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        if (k >= prices.length) return maxProfit2(prices);
        int[][] global = new int[n][k + 1];
        int[][] local = new int[n][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i - 1];
                local[i][j] = Math.max(local[i - 1][j] + diff, global[i - 1][j - 1] + Math.max(diff, 0));
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n - 1][k];
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV test = new BestTimeToBuyAndSellStockIV();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(test.maxProfitSolution2(3, prices));
    }
}