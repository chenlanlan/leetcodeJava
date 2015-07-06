public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }
    public static void main(String[] args){
        BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
        int[] prices = {2, 3, 1, 5};
        System.out.println(test.maxProfit(prices));
    }
}

