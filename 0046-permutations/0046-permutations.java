class Solution {
    public List<List<Integer>> answers;
    public List<List<Integer>> permute(int[] nums) {
        answers = new ArrayList<>();
        // nums 개수만큼 순서있는 경우의 수 구하기
        // 처음부터 for 돌려야함~ visited 필요~
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>());
        return answers;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> list) {
        if(nums.length == list.size()) {
            answers.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;

            list.add(nums[i]);
            visited[i] = true;

            dfs(nums, visited,list);

            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}