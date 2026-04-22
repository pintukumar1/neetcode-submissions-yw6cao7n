class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];
            if (!compareWords(prevWord, currWord, adjList)) {
                return "";
            }
        }

        Set<Character> allChars = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                allChars.add(ch);
            }
        }

        Map<Character, Integer> indegree = new HashMap<>();
        for (char ch : allChars) {
            indegree.put(ch, 0);
        }

        for (List<Character> list : adjList.values()) {
            for (char ch : list) {
                int prevValue = indegree.get(ch);
                indegree.put(ch, prevValue + 1);
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

            if (adjList.containsKey(polled)) {
                for (char neighbor : adjList.get(polled)) {
                    int prevVal = indegree.get(neighbor);
                    indegree.put(neighbor, prevVal - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
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
        String word1, String word2, Map<Character, List<Character>> adjList) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < word1.length() && p2 < word2.length()) {
            char c1 = word1.charAt(p1);
            char c2 = word2.charAt(p2);

            if (c1 != c2) {
                adjList.putIfAbsent(c1, new ArrayList<>());
                adjList.get(c1).add(c2);
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
