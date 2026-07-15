class Solution {
    public List<List<Integer>> answer;
    // n개중 2개 고르는 조합
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());
        System.out.println(answer.size());
        return answer;
    }

    public void dfs(int n, int k, int start, List<Integer> list) {
        // basecase
        if(k == list.size()) {
            answer.add(new ArrayList<>(list));
            return; 
        }
        for(int i=start; i<=n; i++) {
            list.add(i);
            dfs(n, k, i+1, list);
            list.remove(list.size()-1);
        }
    }
}