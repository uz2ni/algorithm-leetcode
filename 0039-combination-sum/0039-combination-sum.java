class Solution {
    public static List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // 모든 조합으로 target가 되는 수 찾기
        // 재귀. n개 중에 n개 조합 (중복 O)
        // basecase: 합산이 target 초과이거나(답에 미포함), 선택된 수 합산 target 이거나(답에 포함)
        // 선택된 리스트 목록 리턴
        List<List<Integer>> results = dfs(nums, target, 0, 0, new ArrayList<>());
        System.out.println(results.toString());
        return results;
    }

    public List<List<Integer>> dfs(int[] nums, int target, int sum, int start, List<Integer> list) {
        List<List<Integer>> totalList = new ArrayList<>();
        if(target < sum) {
           return totalList; 
        }
        if(target == sum) {
            totalList.add(new ArrayList<>(list));
            return totalList;
        }

        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            totalList.addAll(dfs(nums, target, sum+nums[i], i,list));
            list.remove(list.size()-1);
        }
        return totalList;
    }
}
