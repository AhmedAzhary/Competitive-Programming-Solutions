/*
// Definition for a Node.
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
        if(node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> hashMap = new HashMap<>();
        queue.add(node);
        Node current = null;
        Node toBereturned = null;
        while (queue.size() > 0) {
            current = queue.remove();
            if (!hashMap.containsKey(current.val)) {
                Node clonedNode = new Node(current.val);
                if (toBereturned == null)
                    toBereturned = clonedNode;
                for (Node n : current.neighbors) {
                    if (hashMap.containsKey(n.val))
                    {
                        clonedNode.neighbors.add(hashMap.get(n.val));
                        if(!n.neighbors.contains(clonedNode.val))
                            hashMap.get(n.val).neighbors.add(clonedNode);
                    }
                        
                    else
                        queue.add(n);
                }
                hashMap.put(clonedNode.val, clonedNode);

            }
        }
        return toBereturned;
    }
}