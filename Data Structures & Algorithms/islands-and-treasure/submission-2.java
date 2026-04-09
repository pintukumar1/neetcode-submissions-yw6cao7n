class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0, -1},{0, 1}};

        while(!queue.isEmpty()) {
            int[] deleted = queue.poll();
            int r = deleted[0];
            int c = deleted[1];

            for(int[] d: directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 2147483647) {
                    grid[nr][nc] = 1 + grid[r][c];
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
