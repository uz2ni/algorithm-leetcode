class Solution {
    public List<List<Integer>> answers;
    public List<List<Integer>> subsets(int[] nums) {
        // 부분 집합 모두 구하기
        answers = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());   
        return answers;
    }

    public void dfs(int[] nums, int start, List<Integer> list) {
        answers.add(new ArrayList<>(list));

        // if(nums.length == start) return;

        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}