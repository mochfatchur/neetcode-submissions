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
    // plans:
    // 1. check if node is not null
    // 2. check if node is already visited, if yes return the node from hashmap
    // 3. create new instance of Node to clone current value of 'node'
    // 4. put the current node copied to hashmap as visited
    // 5. iterate the neighbor of the neighbor's node copied
    // 6. do

    Map<Node, Node> visitedNode = new HashMap<>();

    public Node cloneGraph(Node node) {
        // check if node null
        if (node == null) 
            return null;
        // check if node already visited
        if (visitedNode.containsKey(node)) 
            return visitedNode.get(node);
        // create clone node
        Node cloneNode = new Node(node.val);
        // set as visited
        visitedNode.put(node, cloneNode);

        // clone the neighbors of node
        for (Node nei : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(nei));
        }

        return cloneNode;
    }
}