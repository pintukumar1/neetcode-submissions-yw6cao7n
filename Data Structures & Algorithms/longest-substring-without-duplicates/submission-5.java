class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int left = 0;

        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, i-left+1);
        }

        return maxLength;
    }
}
