class Solution {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);

        int rows = board.length;
        int columns = board[0].length;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(board[i][j] == start) {
                    if(dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        int rows = board.length;
        int columns = board[0].length;

        if(i<0 || j<0 || i>= rows || j>= columns) {
            return false;
        }

        if(board[i][j] != word.charAt(index)) {
            return false;
        }

        if(word.length() - 1 == index) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean left = dfs(board, i-1, j, word, index+1);
        boolean right = dfs(board, i+1, j, word, index+1);
        boolean top = dfs(board, i, j-1, word, index+1);
        boolean bottom = dfs(board, i, j+1, word, index+1);

        board[i][j] = temp;

        return top || bottom || left || right;
    }
}
