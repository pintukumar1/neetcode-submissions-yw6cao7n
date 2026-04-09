class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, new ArrayList<>(), 0 , result);
        return result;
    }

    public void helper(int[] nums, List<Integer> current, int start, 
        List<List<Integer>> result) {

            result.add(new ArrayList<>(current));

            for(int i=start; i<nums.length; i++) {
                current.add(nums[i]);
                helper(nums, current, i+1, result);
                current.remove(current.size() - 1);
            }

    }
}
