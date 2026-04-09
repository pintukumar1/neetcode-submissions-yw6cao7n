class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), 0, target);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, 
        List<Integer> current,int startIndex, int target) {
            if(target < 0) {
                return;
            }
            if(target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            for(int i=startIndex; i<nums.length; i++) {
                current.add(nums[i]);
                helper(nums, result, current, i, target - nums[i]);
                current.remove(current.size() - 1);
            }
    }
}
