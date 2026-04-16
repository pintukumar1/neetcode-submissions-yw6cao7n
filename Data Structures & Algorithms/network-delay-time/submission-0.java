class Item {
    int target;
    int time;

    Item(int target, int time) {
        this.target = target;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Item>> adjList = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] time: times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            Item item = new Item(v, t);
            adjList.get(u).add(item);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] polled = pq.poll();
            int node = polled[0];
            int time = polled[1];

            if(time > dist[node]) {
                continue;
            }

            for(Item item: adjList.get(node)) {
                int currTime = time + item.time;
                if(currTime < dist[item.target]) {
                    dist[item.target] = currTime;
                    pq.offer(new int[]{item.target, currTime});
                }
            }
        }

        int maxTime = 0;
        for(int i=1; i<dist.length; i++) {
            maxTime = Math.max(maxTime, dist[i]);
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        return maxTime;

    }
}
