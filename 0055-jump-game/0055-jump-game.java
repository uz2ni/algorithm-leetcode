class Solution {
    // 시간초과
    public boolean canJump(int[] nums) {
        return dfs(nums, 0, new boolean[nums.length]);
    }
    public boolean dfs(int[] nums, int startIdx, boolean[] visited) {
        if(startIdx == nums.length-1) return true;
        if(startIdx >= nums.length) {
            visited[startIdx] = true;
            return false;
        }
        
        for(int i=1; i<=nums[startIdx]; i++) {
            if(visited[startIdx+i]) continue;
            if(dfs(nums, startIdx+i, visited)) return true;
        }

        visited[startIdx] = true;
        return false;
    }
}