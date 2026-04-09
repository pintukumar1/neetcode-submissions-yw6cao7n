class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                   int currentArea = dfs(grid, i, j);
                   maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {

        int rows = grid.length;
        int columns = grid[0].length;

        if(i<0 || j<0 || i>= rows || j>= columns || grid[i][j] == 0) {
            return  0;
        }

        grid[i][j] = 0;

        int top = dfs(grid, i-1, j);
        int bottom = dfs(grid, i+1, j);
        int left = dfs(grid, i, j-1);
        int right = dfs(grid, i, j+1);

        return 1 + (top + bottom + left + right);
    }
    
}
