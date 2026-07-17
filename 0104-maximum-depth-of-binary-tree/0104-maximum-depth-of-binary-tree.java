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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    // 정답, 코드 복잡
    public int dfs1(TreeNode curNode, int depth) {
        if(curNode == null) return 0;
        if((curNode.left == null) && (curNode.right == null)) {
            return depth;
        }
        int leftDepth = depth;
        int rightDepth = depth;

        if((curNode.left != null) && (curNode.right != null)) {
            rightDepth = dfs(curNode.right, depth+1);
            leftDepth = dfs(curNode.left, depth+1);
            return Math.max(rightDepth, leftDepth);
        }

        if(curNode.left == null) {
            return dfs(curNode.right, depth+1);
        } 
        if(curNode.right == null) {
            return dfs(curNode.left, depth+1);
        }     

        return depth;
    }

    public int dfs(TreeNode curNode, int depth) {
        if(curNode == null) return depth;
        return Math.max(dfs(curNode.left,depth+1), dfs(curNode.right,depth+1));
    }    
}