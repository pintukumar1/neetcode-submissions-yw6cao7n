class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public boolean helper(String word, int index, TrieNode node) {
        if(index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        if(ch != '.') {
            int i = ch - 'a';

            if(node.children[i]== null){
                return false;
            }
            return helper(word, index+1, node.children[i]);

        } else {

            for(int i=0; i<26; i++) {

                if(node.children[i] != null) {
                    if(helper(word, index+1, node.children[i])) {
                        return true;
                    }
                }
            }

            return false;
        }

    }
}
