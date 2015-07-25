public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int ans = 0;
        int n = prices.length;
        int opt[] = new int[n];
        opt[0] = 0;
        int low = prices[0];
        int curPro = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < low) low = prices[i];
            else if (prices[i] - low > curPro) curPro = prices[i] - low;
            opt[i] = curPro;
        }
        int[] optReverse = new int[n];
        optReverse[n - 1] = 0;
        curPro = 0;
        int high = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > high) high = prices[i];
            else if (high - prices[i] > curPro) curPro = high - prices[i];
            optReverse[i] = curPro;
        }
        for (int i = 0; i < prices.length; i++) {
            int temp = opt[i] + optReverse[i];
            if (temp > ans) ans = temp;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(test.maxProfit(prices));
    }
}