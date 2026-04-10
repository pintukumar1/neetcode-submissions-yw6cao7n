class Solution {
    public boolean canPartition(int[] nums) {
  
      int totalSum = 0;
      for(int num: nums) {
        totalSum += num;
      }

      if(totalSum % 2 != 0) {
        return false;
      }
      
      int target = totalSum / 2;
      boolean[] dp = new boolean[target+1];
      dp[0] = true;

      for(int i=0; i<nums.length; i++) {
        for(int j=target; j>=nums[i]; j--) {
          if(dp[j-nums[i]]) {
            dp[j] = true;
          }
        }
      }
      return dp[target];
    }
}
