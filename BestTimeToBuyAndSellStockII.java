public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                continue;
            }
            profit += prices[i - 1] - min;
            min = prices[i];
        }
        profit += prices[prices.length - 1] - min;
        return profit;
    }
    public static void main(String[] args){
        BestTimeToBuyAndSellStockII test = new BestTimeToBuyAndSellStockII();
        int[] prices = {2, 3, 1, 5};
        System.out.println(test.maxProfit(prices));
    }
}

