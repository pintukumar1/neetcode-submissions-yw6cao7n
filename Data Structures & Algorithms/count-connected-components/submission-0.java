class Solution {
    public int countComponents(int n, int[][] edges) {
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
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(adjList, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int i) {
        visited[i] = true;

        for(int neighbour: adjList.get(i)) {
            if(!visited[neighbour]) {
                dfs(adjList, visited, neighbour);
            }
        }
    }
}
