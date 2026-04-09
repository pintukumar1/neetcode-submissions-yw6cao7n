class Solution {

    String[] map = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        helper(digits, 0, "", result);   
        return result;
    }

    public void helper(String digits, int index, String current, List<String> result) {
        if(index == digits.length()) {
            result.add(current);
            return;
        }

        char ch = digits.charAt(index);
        String letters = map[ch-'0'];
        for(char chrr: letters.toCharArray()) {
            helper(digits, index + 1, current+chrr ,result);
        }
    } 
}
