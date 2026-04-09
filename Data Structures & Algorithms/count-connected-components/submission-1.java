class Solution {
    public int countComponents(int n, int[][] edges) {
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

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                count++;
                dfs(adjList, visited, i);
            }
        }

        return count;
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int index) {
        if(visited[index]) return;
        visited[index] = true;
        for(Integer neigh: adjList.get(index)) {
            dfs(adjList, visited, neigh);
        }
    }
}
