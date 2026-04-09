class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];


        for(int i=0; i<rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, columns - 1);
        }

        for(int j=0; j<columns; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, rows-1, j);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
        int rows = heights.length;
        int columns = heights[0].length;
        if(i<0 || j<0 || i>=rows || j>= columns || ocean[i][j] == true) {
            return;
        }

        ocean[i][j] = true;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int[] d: directions) {
            int nr = i + d[0];
            int nc = j + d[1];

            if(nr>=0 && nc >= 0 && nr<rows && nc<columns && heights[nr][nc] >= heights[i][j]) {
                dfs(heights, ocean, nr, nc);
            }
        }
    }
}
