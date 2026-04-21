class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            String currWord = words[i];
            String prevWord = words[i - 1];

            if (!compareWords(currWord, prevWord, map)) {
                return "";
            }
        }

        Map<Character, Integer> indegree = new HashMap<>();
        Set<Character> allChars = new HashSet<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                allChars.add(ch);
            }
        }

        for (char ch : allChars) {
            indegree.put(ch, 0);
        }

        for (List<Character> list : map.values()) {
            for (char ch : list) {
                int newVal = indegree.get(ch);
                indegree.put(ch, newVal + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char polled = queue.poll();
            sb.append(polled);

            if (map.get(polled) != null) {
                for (Character ch : map.get(polled)) {
                    int newVal = indegree.get(ch) - 1;
                    indegree.put(ch, newVal);
                    if (indegree.get(ch) == 0) {
                        queue.offer(ch);
                    }
                }
            }
        }

        if (sb.length() != allChars.size()) {
            return "";
        }

        return sb.toString();
    }

    public boolean compareWords(
        String currWord, String prevWord, Map<Character, List<Character>> map) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < prevWord.length() && p2 < currWord.length()) {
            char c1 = prevWord.charAt(p1);
            char c2 = currWord.charAt(p2);

            if (c1 != c2) {
                map.putIfAbsent(c1, new ArrayList<>());
                map.get(c1).add(c2);
                return true;
            }

            p1++;
            p2++;
        }

        if (prevWord.length() > currWord.length()) {
            return false;
        }
        return true;
    }
}
