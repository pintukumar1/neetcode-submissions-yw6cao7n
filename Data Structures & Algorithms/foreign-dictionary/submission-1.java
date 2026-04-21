class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            if (!compareWords(word1, word2, map)) {
                return "";
            }
        }

        Set<Character> allChars = new HashSet<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
            }
        }

        Map<Character, Integer> indegree = new HashMap<>();
        for (char ch : allChars) {
            indegree.put(ch, 0);
        }

        for (Map.Entry<Character, List<Character>> entry : map.entrySet()) {
            char key = entry.getKey();
            for (char ch : entry.getValue()) {
                indegree.putIfAbsent(ch, 0);
                int prevVal = indegree.get(ch);
                indegree.put(ch, prevVal + 1);
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
            Character polled = queue.poll();
            sb.append(polled);

            if (map.get(polled) != null) {
                for (Character neighbor : map.get(polled)) {
                    int prevVal = indegree.get(neighbor);
                    indegree.put(neighbor, prevVal - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        }

        return sb.toString();
    }

    public boolean compareWords(String word1, String word2, Map<Character, List<Character>> map) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < word1.length() && p2 < word2.length()) {
            char c1 = word1.charAt(p1);
            char c2 = word2.charAt(p2);

            if (c1 != c2) {
                map.putIfAbsent(c1, new ArrayList<>());
                map.get(c1).add(c2);
                return true;
            }

            p1++;
            p2++;
        }

        if (word1.length() > word2.length()) {
            return false;
        }

        return true;
    }
}
