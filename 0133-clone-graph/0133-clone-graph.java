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
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>(); // old, new
        Queue<Node> queue = new ArrayDeque<>();

        Node startClone = new Node(node.val);
        map.put(node, startClone);
        queue.add(node); // old

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    queue.add(nei);
                }

                map.get(cur).neighbors.add(map.get(nei));
            }
        }

        return startClone;
    }
}