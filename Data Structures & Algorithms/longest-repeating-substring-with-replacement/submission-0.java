class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;
        for(int i=0;i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i) , 0) + 1 );
            maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));

            while(i-left+1-maxFreq > k) {
                char leavingItem = s.charAt(left);
                if(map.containsKey(leavingItem)) {
                    if(map.get(leavingItem) == 1) {
                        map.remove(leavingItem);
                    } else {
                        map.put(leavingItem, map.get(leavingItem) - 1);
                    }
                }
                left++;
            }
            maxLength = Math.max(maxLength , i-left+1);
        }

        return maxLength;
    }
}
