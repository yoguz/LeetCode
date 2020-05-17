public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        Q122_Best_Time_to_Buy_and_Sell_Stock_II obj = new Q122_Best_Time_to_Buy_and_Sell_Stock_II();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(obj.maxProfit(new int[]{5,4,3,2,1}));
        System.out.println(obj.maxProfit(new int[]{100,35,43,2,56,72,43,56,123}));
    }
}
