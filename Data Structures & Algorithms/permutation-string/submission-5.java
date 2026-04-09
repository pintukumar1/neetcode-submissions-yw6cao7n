class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];

        for(char ch: s1.toCharArray()) {
            count[ch - 'a']++;
        }

        int left = 0;
        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            count[ch - 'a']--;

            while(count[ch - 'a'] < 0) {
                count[s2.charAt(left) - 'a']++;
                left++;
            }
            if(i-left+1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
