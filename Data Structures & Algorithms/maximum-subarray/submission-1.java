class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        int start = 0;
        int end = 0;

        for(int i=1; i<nums.length; i++) {
            if(currentSum < 0) {
                currentSum = nums[i];
                start = i;
            } else {
                currentSum += nums[i];
            }

            if(currentSum > maxSum) {
                maxSum = currentSum;
                end = i;
            }

        }

        return maxSum;

    }
}
