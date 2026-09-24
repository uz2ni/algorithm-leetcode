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
    public List<List<Integer>> answers;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answers = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return answers;
    }

    public void dfs(TreeNode node, int targetSum, List<Integer> list) {
        if(node == null) return;

        list.add(node.val);
        targetSum-=node.val;

        if(node.left == null && node.right == null && targetSum == 0) {
            answers.add(new ArrayList<>(list));
        }

        dfs(node.left, targetSum, list);
        dfs(node.right, targetSum, list);

        list.remove(list.size()-1);
    }
}