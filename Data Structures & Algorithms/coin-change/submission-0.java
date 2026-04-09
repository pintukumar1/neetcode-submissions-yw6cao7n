class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<=amount; i++) {
            for(int coin: coins) {
                int remaining = i - coin;

                if(remaining>=0 && dp[remaining] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[remaining]+1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
