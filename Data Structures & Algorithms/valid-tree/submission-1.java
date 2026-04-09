class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;

        boolean[] visited = new boolean[n];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int polled = queue.poll();

            for(Integer neighbour: adjList.get(polled)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    count++;
                    queue.offer(neighbour);
                }
            }
        }

        return count == n;

    }
}
