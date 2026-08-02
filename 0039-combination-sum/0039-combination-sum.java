class Solution {
    public List<List<Integer>> answers;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answers = new ArrayList<>();
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return answers;
    }

    public void dfs(int[] candidates, int target, int start, int sum, List<Integer> list) {
        if(sum == target) {
            answers.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, i, sum+candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}