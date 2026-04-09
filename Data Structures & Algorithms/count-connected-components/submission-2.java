class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int count = 0;

        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                dfs(adjList, i, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(List<List<Integer>> adjList, int i, Set<Integer> visited) {
        visited.add(i);

        for(int neighbor: adjList.get(i)) {
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(adjList, neighbor, visited);
            }
        }
    }
}
