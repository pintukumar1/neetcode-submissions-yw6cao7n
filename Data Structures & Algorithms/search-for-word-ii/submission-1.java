class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    String word;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode node = buildTrie(words);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, node, result);
            }
        }
        return result;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for(String word: words) {
            node = root;
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
            node.word = word;
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        int rows = board.length;
        int columns = board[0].length;
        if(i<0 || j<0 || i>= rows || j >= columns || board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];
        int index = ch - 'a';
        if(node.children[index] == null) {
            return;
        }
        node = node.children[index];
        if(node.isEnd) {
            result.add(node.word);
            node.isEnd = false; 
        }

        char temp = board[i][j];
        board[i][j] = '#';

        dfs(board, i+1, j, node, result);
        dfs(board, i-1, j, node, result);
        dfs(board, i, j+1, node, result);
        dfs(board, i, j-1, node, result);
        
        board[i][j] = temp;
    }
}
