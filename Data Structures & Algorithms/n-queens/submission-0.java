class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0, result);
        return result;
    }

    public void dfs(char[][] board, int row, List<List<String>> result) {
        if(row == board.length) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
        }

        for(int j=0; j<board[0].length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                dfs(board, row+1, result);
                board[row][j] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int column) {

        for(int i=0; i<row; i++) {
            if(board[i][column] == 'Q') {
                return false;
            }
        }

        for(int i=row-1, j=column-1; i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i=row-1, j=column+1; i>=0 && j<board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
