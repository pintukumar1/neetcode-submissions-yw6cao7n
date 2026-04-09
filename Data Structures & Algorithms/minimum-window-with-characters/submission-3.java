class Solution {
    public String minWindow(String s, String t) {
      int[] count = new int[128];

      for(char c: t.toCharArray()) {
        count[c]++;
      }

      int required = t.length();
      int left = 0;
      int start = 0;
      int minLength = Integer.MAX_VALUE;

      for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if(count[ch] > 0) {
          required--;
        }
        count[ch]--;

        while(required == 0) {
          if(i-left+1 < minLength) {
            minLength = i-left+1;
            start = left;
          }

          char leftChar = s.charAt(left);
          count[leftChar]++;
          if(count[leftChar] > 0) {
            required++;
          }
          left++;
        }
      }
      return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start+minLength);  
    }
}
