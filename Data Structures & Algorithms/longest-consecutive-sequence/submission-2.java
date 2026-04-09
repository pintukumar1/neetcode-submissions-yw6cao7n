class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int current = 0;
        int count = 0;
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(!set.contains(num - 1)) {
                current = num;
                count = 1;

                while(set.contains(current + 1)) {
                    current = current + 1;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
