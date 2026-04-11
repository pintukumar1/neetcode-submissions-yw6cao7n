class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for(int i=0; i<prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevSold, prevRest);
        }

        return Math.max(rest, sold);
    }
}
