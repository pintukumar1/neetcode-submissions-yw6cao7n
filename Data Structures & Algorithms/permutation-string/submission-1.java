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
            
            while(i-left+1 > s1.length()) {
                char leavingItem = s2.charAt(left);
                if(windowMap.containsKey(leavingItem)) {
                    if(windowMap.get(leavingItem) == 1) {
                        windowMap.remove(leavingItem);
                    } else {
                        windowMap.put(leavingItem,windowMap.get(leavingItem) - 1);
                    }
                }
                left++;
            }

            if(map.size() == windowMap.size()) {
                boolean compareVal = compare(map, windowMap);
                if(compareVal) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean compare(Map<Character, Integer> originalMap,Map<Character, Integer> windowMap) {
        boolean areMapsEqual = true;
        for(Map.Entry<Character, Integer> entry : originalMap.entrySet()) {
            if(windowMap.containsKey(entry.getKey()) ) {
                if(entry.getValue() != windowMap.get(entry.getKey())) {
                    areMapsEqual = false;
                    break;
                } 
            } else {
                areMapsEqual = false;
            }
        }
        return areMapsEqual;
    }
}
