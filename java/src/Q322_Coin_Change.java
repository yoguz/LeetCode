import java.util.Arrays;

public class Q322_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0)
            return 0;
        else if (coins.length == 0 || amount < coins[0])
            return -1;

        int[] memo = new int[amount+1];
        memo[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            memo[i] = -1;
        }

        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; ++j) {
                int res;
                if (i - coins[j] < 0)
                    continue;
                else if (memo[i - coins[j]] == -1) {
                    res = Integer.MAX_VALUE;
                } else {
                    res = 1 + memo[i - coins[j]];
                }
                min = Math.min(min, res);
            }
            memo[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return memo[amount];
    }

    public static void main(String[] args) {
        Q322_Coin_Change obj = new Q322_Coin_Change();
        System.out.println(obj.coinChange(new int[]{5,6,7}, 11));
        System.out.println(obj.coinChange(new int[]{1,2,3}, 11));
        System.out.println(obj.coinChange(new int[]{1,2,3}, 1));
        System.out.println(obj.coinChange(new int[]{2}, 1));
        System.out.println(obj.coinChange(new int[]{2}, 0));
        System.out.println(obj.coinChange(new int[]{1,3,5,7}, 19));
    }
}
