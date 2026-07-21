class Solution {
    public List<List<Integer>> answers;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answers = new ArrayList<>();
        // 선택 조합이 target 이 되는 모든 조합 리스트 반환
        // 조합, start 존재, 현재까지 sum
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return answers;
    }

    public void dfs(int[] cd, int target, int start, int sum, List<Integer> list) {
        // basescase
        if(sum == target) {
            answers.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i=start; i<cd.length; i++) {
            list.add(cd[i]);

            dfs(cd, target, i, sum+cd[i], list); // i 왜 현재 숫자부터 보는거지??

            list.remove(list.size()-1);
        }
    }
    
}