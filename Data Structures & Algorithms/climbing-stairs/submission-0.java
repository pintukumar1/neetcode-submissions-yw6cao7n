class Solution {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(2);


        for(int i=2; i<n; i++) {
            dp.add(dp.get(i-2) + dp.get(i-1));
        }

        return dp.get(n-1);
    }
 }
