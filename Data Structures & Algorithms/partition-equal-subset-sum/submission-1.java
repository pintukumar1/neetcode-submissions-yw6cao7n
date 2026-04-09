class Solution {
    public boolean canPartition(int[] nums) {
      int n = nums.length;
      int sum = 0;
      for(int i=0; i<nums.length; i++) {
        sum+=nums[i];
      }
      if (sum % 2 != 0) return false;

      int target = sum/2;
      boolean[][] dp = new boolean[n+1][target+1]; 
      dp[0][0] = true;
      for(int i=0; i<=n; i++) {
        dp[i][0] = true;
      }

      for(int i=1; i<=n; i++) {
        for(int j=1; j<=target; j++) {
          if(j>=nums[i-1]) {
            dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
          } else {
            dp[i][j] = dp[i-1][j];
          }
        }
      }
      return dp[n][target];
    }
}
