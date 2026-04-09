class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[][] q = new int[n][2];

        for(int i=0; i<n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a , b) -> a[0] - b[0]);

        int[] result = new int[n];
        Arrays.fill(result, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int i = 0;
        
        // Step 3: Process each query
        for (int[] query : q) {
            int val = query[0];
            int index = query[1];
            
            // Add intervals where left <= query
            while (i < intervals.length && intervals[i][0] <= val) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;
                
                pq.offer(new int[]{length, right});
                i++;
            }
            
            // Remove intervals where right < query
            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }
            
            // Top of heap = smallest valid interval
            if (!pq.isEmpty()) {
                result[index] = pq.peek()[0];
            }
        }
        
        return result;
    }
}
