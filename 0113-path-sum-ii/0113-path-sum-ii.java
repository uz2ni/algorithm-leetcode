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
    List<List<Integer>> answers = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0, new ArrayList<>());
        return answers;
    }

    // 안풀림
    public void dfs1(TreeNode node, int targetSum, int sum, List<Integer> list) {
        String str = ((node == null) ? "null" : String.valueOf(node.val));
        System.out.println("dfs 입장: " + str + ", sum: " + sum);

        if(node == null && sum == targetSum) {
            answers.add(new ArrayList<>(list));
        }

        if(node == null) {
            return;
        }        

        list.add(node.val);
        dfs(node.left, targetSum, sum+node.val, list);
        dfs(node.right, targetSum, sum+node.val, list);
        list.remove(list.size()-1);
        
        System.out.println("sum: " + sum);
        System.out.println("list: " + list.toString());
        
    }

    // 정답 풀이
    public void dfs(TreeNode node, int targetSum, int sum, List<Integer> list) {
        if(node == null) return;

        sum += node.val;
        list.add(node.val);

        // 리프노드일 때만 정답 체크
        if(node.left == null && node.right == null && sum == targetSum) {
            answers.add(new ArrayList<>(list));
        }

        dfs(node.left, targetSum, sum, list);
        dfs(node.right, targetSum, sum, list);

        list.remove(list.size()-1);
    }
}