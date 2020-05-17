public class Q121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int profit = 0, lowest = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - lowest > profit)
                profit = prices[i] - lowest;

            if (lowest > prices[i])
                lowest = prices[i];
        }

        return profit;
    }

    public static void main(String[] args) {
        Q121_Best_Time_to_Buy_and_Sell_Stock obj = new Q121_Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.maxProfit(new int[]{5,4,3,2,1}));
    }
}
