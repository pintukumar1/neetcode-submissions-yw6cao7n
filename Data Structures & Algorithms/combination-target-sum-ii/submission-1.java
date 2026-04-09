class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        helper(candidates, new ArrayList<>(), result, 0, target);
        return result;
    }

    public void helper(int[] candidates, List<Integer> current,
        List<List<Integer>> result , int startIndex, int target) {

            if(target < 0) {
                return;
            }
            if(target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }

            for(int i=startIndex; i<candidates.length; i++) {
                if(i>startIndex && candidates[i] == candidates[i-1]) continue;
                current.add(candidates[i]);
                helper(candidates, current, result, i+1, target-candidates[i]);
                current.remove(current.size() - 1);
            }
     }
}
