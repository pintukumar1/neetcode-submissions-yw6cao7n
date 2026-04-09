class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;

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
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);
        int count = 1;
    
        while(!queue.isEmpty()) {
            int polled = queue.poll();
            for(int neighbor: adjList.get(polled)) {
                if(!visited.contains(neighbor)) {
                    count++;
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(count);

        return count == n;
    }
}
