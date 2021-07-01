public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfitOld(int[] prices) {
        if (prices.length < 2)
            return 0;

        int profit = 0, low = prices[0];
        boolean bought = false;
        for (int i = 0; i < prices.length-1; ++i) {
            if (bought) {
                if (prices[i] > prices[i+1]) {
                    bought = false;
                    profit += prices[i] - low;
                }
            } else {
                if (prices[i] < prices[i+1]) {
                    bought = true;
                    low = prices[i];
                }
            }

        }
        if (bought) {
            profit += prices[prices.length-1] - low;
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
        int lastBuy = -1, profit = 0, n = prices.length;
        for (int i = 0; i < n-1; ++i) {
            if (lastBuy == -1 && prices[i] < prices[i+1]) {
                lastBuy = prices[i];
            } else if (lastBuy != -1 && prices[i] < lastBuy) {
                lastBuy = prices[i];
            } else if (lastBuy != -1 && prices[i] > prices[i+1]) {
                profit += prices[i] - lastBuy;
                lastBuy = -1;
            }
        }

        if (prices[n-1] > lastBuy && lastBuy != -1)
            profit += prices[n-1] - lastBuy;

        return profit;
    }

    public int maxProfitBest(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    public static void main(String[] args) {
        Q122_Best_Time_to_Buy_and_Sell_Stock_II obj = new Q122_Best_Time_to_Buy_and_Sell_Stock_II();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(obj.maxProfit(new int[]{5,4,3,2,1}));
        System.out.println(obj.maxProfit(new int[]{100,35,43,2,56,72,43,56,123}));
    }
}
