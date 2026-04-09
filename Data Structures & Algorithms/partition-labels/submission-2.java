class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        List<Integer> result = new ArrayList<>();
        int maxEnd = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            maxEnd = Math.max(maxEnd, map.get(ch));
            if(maxEnd == i) {
                result.add(i-start+1);
                start = i + 1;
            }
        }

        return result;
    }
}
