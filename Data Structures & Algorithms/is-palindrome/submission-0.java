class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left<right) {
            boolean isLeftChar = Character.isLetterOrDigit(s.charAt(left));
            boolean isRightChar = Character.isLetterOrDigit(s.charAt(right));
            
            if(!isLeftChar) {
                left++;
            } else if(!isRightChar) {
                right--;
            } else if(Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
