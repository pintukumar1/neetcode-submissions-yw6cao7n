class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;

        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                } else if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};

        while(!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] deleted = queue.poll();
                int r = deleted[0];
                int c = deleted[1];

                for(int[] d: directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }

        return freshCount>0 ? -1 : minutes;
    }
}
