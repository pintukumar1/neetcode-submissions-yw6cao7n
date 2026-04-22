class Pair {
    int target;
    int time;

    Pair(int target, int time) {
        this.target = target;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new Pair(v, w));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {k, 0});
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int prevNode = polled[0];
            int prevTime = polled[1];
            if (prevTime > dist[prevNode]) {
                continue;
            }

            if (adjList.get(prevNode) != null) {
                for (Pair pair : adjList.get(prevNode)) {
                    int neighborNode = pair.target;
                    int neighborTime = prevTime + pair.time;

                    if (neighborTime < dist[neighborNode]) {
                        dist[neighborNode] = neighborTime;
                        pq.offer(new int[] {neighborNode, neighborTime});
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dist[i]);
        }
        return result;
    }
}
