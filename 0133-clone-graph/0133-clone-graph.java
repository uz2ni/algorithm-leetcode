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

        Map<Node, Node> visited = new HashMap<>(); // 원본->복제본 매핑

        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(Node n : cur.neighbors) {
                if(!visited.containsKey(n)) {
                    // 복제 안된 노드라면 복제본 생성, 방문 처리, 큐 삽입
                    visited.put(n, new Node(n.val));
                    q.offer(n);
                }
                // 원본의 이웃관계를 복제본에도 연결
                visited.get(cur).neighbors.add(visited.get(n));

            }
        }

        return newNode;
        
    }
}