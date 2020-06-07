public class Q518_Coin_Change_2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Q518_Coin_Change_2 obj = new Q518_Coin_Change_2();
        System.out.println(obj.change(5, new int[]{1,2,5}));
        System.out.println(obj.change(2, new int[]{3,5,7}));
    }
}
