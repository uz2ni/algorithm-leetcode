class Solution {
    public int maxLength = 0;

    // 타임아웃
    public int arrayNesting1(int[] nums) {
        Set set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            dfs1(nums, i, set);
        }
        return maxLength;
    }
    public void dfs1(int[] nums, int index, Set<Integer> set) {
        if(set.contains(index)) {
            maxLength = Math.max(maxLength, set.size());
            return;
        }
        
        set.add(index);
        System.out.println(set.toString());
        dfs1(nums, nums[index], set);
    }

    // visited 사용. 배열의 독립적인 cycle만 존재
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) {
            dfs(nums, i, visited);
        }
        return maxLength;
    }
    public void dfs(int[] nums, int index, boolean[] visited) {
        int cnt = 0;

        while(!visited[index]) {
            visited[index] = true;
            cnt++;
            index = nums[index];
        }

        maxLength = Math.max(maxLength, cnt);
    }    
}