/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 1. bfs
    public List<Integer> rightSideView1(TreeNode root) {
        
        if(root == null) return new ArrayList<>();

        List<Integer> answers = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();

                if(i == size-1) answers.add(cur.val);

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }

        return answers;
    }

    // 2. dfs
    public List<Integer> answers;
    public List<Integer> rightSideView(TreeNode root) {
        answers = new ArrayList<>();
        dfs(root, 0);
        return answers;
    }

    public void dfs(TreeNode start, int depth) {
        if(start == null) return;
        
        if(answers.size() == depth) {
            answers.add(start.val);
        }

        if(start.right != null) dfs(start.right, depth+1);
        if(start.left != null) dfs(start.left, depth+1);
    }
}