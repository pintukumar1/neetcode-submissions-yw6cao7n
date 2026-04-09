class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            if(i - left + 1 - maxFreq > k) {
                char leaving = s.charAt(left);
                if(map.get(leaving) == 1) {
                    map.remove(leaving);
                } else {
                    map.put(leaving, map.get(leaving) - 1);
                }
                left++;
            }

            maxLength = Math.max(maxLength, i-left+1);
        }   
        return maxLength;
    }
}
