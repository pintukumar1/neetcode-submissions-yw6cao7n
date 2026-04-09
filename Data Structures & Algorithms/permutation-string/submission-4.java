class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0; 
        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if(i-left+1 >s1.length()) {
                char leaving = s2.charAt(left);
                if(windowMap.get(leaving) == 1) {
                    windowMap.remove(leaving);
                } else {
                    windowMap.put(leaving, windowMap.get(leaving) - 1);
                }
                left++;
            }

            if(compare(map, windowMap)) {
                return true;
            }
        }

        return false;
    }

    public boolean compare(Map<Character, Integer> map, Map<Character, Integer> windowMap) {
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() != windowMap.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    } 
}
