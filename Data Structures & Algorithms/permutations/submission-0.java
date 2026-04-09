class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        helper(nums, result, new ArrayList<>(), visited);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result,
         List<Integer> current, boolean[] visited) {

            if(current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }

            for(int i=0; i<nums.length; i++) {
                if(visited[i]) continue;
                current.add(nums[i]);
                visited[i] = true;
                helper(nums, result, current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
    }
}
