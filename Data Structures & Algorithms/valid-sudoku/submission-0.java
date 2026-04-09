class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] columnSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        int rows = board.length;
        int columns = board[0].length;

        for(int i=0; i<rows; i++) {
            rowSet[i] = new HashSet<>();
            columnSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(board[i][j] == '.') continue;
                char value = board[i][j];
                int boxId = (i/3)*3+(j/3);

                if(rowSet[i].contains(value) || columnSet[j].contains(value) || 
                boxSet[boxId].contains(value)) {
                    return false;
                }
                rowSet[i].add(value);
                columnSet[j].add(value);
                boxSet[boxId].add(value);
            }
        }

        return true;
    }
}
