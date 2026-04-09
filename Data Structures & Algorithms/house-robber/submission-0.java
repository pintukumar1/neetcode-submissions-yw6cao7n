class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int prev2 = 0;

        for(int i=0; i<nums.length; i++) {
            int current = Math.max(prev, prev2 + nums[i]);
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}
