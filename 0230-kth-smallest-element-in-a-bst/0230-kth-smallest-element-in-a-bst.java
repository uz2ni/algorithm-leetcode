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
    public int cnt = 0;
    public int answer = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    public void inorder(TreeNode node, int k) {
        if(node == null) {
            return;
        }
        if(cnt == k) {
            return;
        }

        inorder(node.left, k);

        if(cnt == k) {
            return;
        }

        answer = node.val;
        cnt++;

        inorder(node.right, k);
    }
}