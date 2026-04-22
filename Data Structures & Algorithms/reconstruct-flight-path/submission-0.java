class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);

            map.putIfAbsent(source, new PriorityQueue<>());
            map.get(source).offer(destination);
        }

        List<String> result = new ArrayList<>();

        dfs("JFK", map, result);

        Collections.reverse(result);
        return result;
    }

    public void dfs(String airport, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> pq = map.get(airport);

        if (pq != null) {
            while (!pq.isEmpty()) {
                String next = pq.poll();
                dfs(next, map, result);
            }
        }
        
        result.add(airport);
    }
}
