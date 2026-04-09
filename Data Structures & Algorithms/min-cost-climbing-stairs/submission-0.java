class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;
        int prev2 = 0;

        for(int i=0; i<cost.length; i++) {
            int current = cost[i] + Math.min(prev, prev2);
            prev2 = prev;
            prev = current;
        }

        return Math.min(prev, prev2);


    }
}
