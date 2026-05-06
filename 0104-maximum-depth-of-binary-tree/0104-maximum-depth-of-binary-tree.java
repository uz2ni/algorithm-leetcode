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
        // null 닿을때까지 탐색. null 만나면 현재까지 길이 리턴
        return recursion(root, 0);
    }

    public int recursion(TreeNode root, int length) {
        if(root == null) return length;

        int leftDepth = recursion(root.left, length+1);
        int rightDepth = recursion(root.right, length+1);

        return Math.max(leftDepth, rightDepth);

    }
}
