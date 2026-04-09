/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){ 
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    public void dfs(Node node, Map<Node, Node> map) {

        if(map.containsKey(node)) {
            return;
        }

        map.put(node, new Node(node.val));

        for(Node neighbor: node.neighbors) {
            if(!map.containsKey(neighbor)) {
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}