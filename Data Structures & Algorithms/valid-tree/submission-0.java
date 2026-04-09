class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

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

        int count = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(visited[node]) continue;

            visited[node] = true;
            count++;

            for(int neighbour: adjList.get(node)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                }
            }
        }

        System.out.println(count);

        return count == n;

    }
    
}
