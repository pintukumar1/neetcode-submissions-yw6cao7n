class Solution {

    int startIndex = 0;
    int endIndex = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }

        return s.substring(startIndex, endIndex+1);
    }

    public void helper(String s, int left, int right) {
        while(left>=0 && right<s.length()) {

            if(s.charAt(left) == s.charAt(right)) {
                int currentLength = right-left+1;
                if(currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = left;
                    endIndex = right;
                }
                left--;
                right++;
            } else {
                break;
            }
        }
    }
}
