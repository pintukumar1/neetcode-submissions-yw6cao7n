class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d: directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 2147483647) {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }




    }
}
