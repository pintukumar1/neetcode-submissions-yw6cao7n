class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int start = 0;
        int currentEnd = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            currentEnd = Math.max(currentEnd, map.get(ch));
            if(i==currentEnd) {
                result.add(i-start+1);
                start = i+1;
            }
        }

        return result;
    }
}
