class Solution {
    public int maxProduct(int[] nums) {
        int prevMin = nums[0];
        int prevMax = nums[0];

        int result = nums[0];

        for(int i=1; i<nums.length; i++) {
            int current = nums[i];
            int newMax = Math.max(current, Math.max(current*prevMax, current*prevMin));
            int newMin = Math.min(current,  Math.min(current*prevMax, current*prevMin));
            prevMin =newMin;
            prevMax = newMax;

            result = Math.max(result, newMax);

        }
        return result;
    }
}
