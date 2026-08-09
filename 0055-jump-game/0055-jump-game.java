class Solution {
    // 1. DFS + memoization : O(N^2) - 성공, 최적X
    public boolean canJump1(int[] nums) {
        return dfs(nums, 0, new boolean[nums.length]);
    }
    public boolean dfs(int[] nums, int startIdx, boolean[] visited) {
        if(startIdx == nums.length-1) return true;
        
        for(int i=1; i<=nums[startIdx]; i++) {
            if(startIdx+i >= nums.length) break;
            if(visited[startIdx+i]) continue;
            if(dfs(nums, startIdx+i, visited)) return true;
        }

        visited[startIdx] = true;
        return false;
    }

    // 2. 그리디 알고리즘 O(N) - 완전 이해 안되었음
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0; i<nums.length; i++) {
            if(maxReach < i) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach >= nums.length-1) return true;
        }
        return true; // nums.length==0 일 때만 도달.
    }
}