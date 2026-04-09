class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);    
        }

        int required = map.size();
        int formed = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        for(int i=0; i<s.length(); i++) {
          char ch = s.charAt(i);
          windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

          if(null != map.get(ch) && windowMap.get(ch) == map.get(ch)) {
            formed++;
          }

          while(formed == required)  {
            if(i-left+1 < minLength) {
                minLength = i-left+1;
                answer = s.substring(left, i+1);
            }
            char leaving = s.charAt(left);
            windowMap.put(leaving, windowMap.get(leaving) - 1);

            if(map.containsKey(leaving) && windowMap.get(leaving) < map.get(leaving) ) {
                formed--;
            }
            left++;
          }
        }

        return answer;
    }
}
