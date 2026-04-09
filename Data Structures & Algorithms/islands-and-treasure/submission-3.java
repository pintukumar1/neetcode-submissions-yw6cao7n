class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] polled = queue.poll();
            int i = polled[0];
            int j = polled[1];

            for(int[] d: directions) {
                int nr = i + d[0];
                int nc = j + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 2147483647) {
                    grid[nr][nc] = grid[i][j] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
