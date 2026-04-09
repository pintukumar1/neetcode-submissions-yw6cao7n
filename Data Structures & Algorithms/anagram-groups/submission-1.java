class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
          char[] charArray = strs[i].toCharArray();
          Arrays.sort(charArray);
          String sorted = new String(charArray);

          if(map.get(sorted) == null) {
            map.put(sorted, new ArrayList<>());
          }
          map.get(sorted).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
          result.add(entry.getValue());
        }

        return result;
    }
}
