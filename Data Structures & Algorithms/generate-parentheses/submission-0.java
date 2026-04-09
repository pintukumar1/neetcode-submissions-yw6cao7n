class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", 0, 0, n, result);
        return result;
    }

    public void helper(String current, int openCount, int closeCount,
         int n, List<String> result) {

            if(current.length() == 2*n) {
                result.add(current);
                return;
            }

            if(openCount<n) {
                helper(current + "(", openCount+1, closeCount, n, result);
            }

            if(closeCount < openCount) {
                helper(current + ")", openCount, closeCount+1, n, result);
            }
    }
}
