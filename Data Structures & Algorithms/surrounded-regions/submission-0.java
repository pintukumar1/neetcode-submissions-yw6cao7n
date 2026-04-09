class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        for(int i=0; i<rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, columns-1);
        }

        for(int j=0; j<columns; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int columns = board[0].length;
        if(i<0 || j<0 || i>= rows|| j>= columns || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        for(int[] d: directions) {
            dfs(board, i+d[0], j+d[1]);
        }
    }
}
