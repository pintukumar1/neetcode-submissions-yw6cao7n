class Solution {
    public int trap(int[] height) {
        int maxWater = 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;


        while(left< right) {
            if(height[left]<=height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                maxWater += (maxLeft - height[left]);
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                maxWater += (maxRight- height[right]);
                right--;
            }
        }

        return maxWater;
    }
}
