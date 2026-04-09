class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prev = 0;
        int prev2 = 0;

        for(int i=1; i<nums.length; i++) {
            int current = Math.max(prev, nums[i]+prev2);
            prev2 = prev;
            prev = current;
        }

        int result = prev;

        prev = 0;
        prev2 = 0;
        for(int i=0; i<nums.length - 1; i++) {
            int current = Math.max(prev, nums[i]+prev2);
            prev2 = prev;
            prev = current;
        }

        return Math.max(result,prev);

    }
}
