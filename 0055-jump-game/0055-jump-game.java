class Solution {
    // 1. DFS + memoization(DP 최적화가 일부가 들어간 DFS) : O(N^2) - 성공, 최적X
    // 정확히 DP 방식이 아닌 이유 : 모든 부분의 결과(실패,성공)를 캐싱해야하는데 풀이에서는 실패만 캐싱함.
    public boolean canJump1(int[] nums) {
        return dfs(nums, 0, new boolean[nums.length]);
    }
    public boolean dfs(int[] nums, int startIdx, boolean[] visited) {
        if(startIdx == nums.length-1) return true;
        
        for(int i=1; i<=nums[startIdx]; i++) {
            if(startIdx+i >= nums.length) break;
            if(visited[startIdx+i]) continue;
            if(dfs(nums, startIdx+i, visited)) return true; // 성공 시 바로 종료
        }

        visited[startIdx] = true; // startIdx 시작으로는 도달 실패 표시
        return false;
    }

    // 2. 그리디 알고리즘 O(N) - 완전 이해 안되었음
    public boolean canJump2(int[] nums) {
        int maxReach = 0;
        for(int i=0; i<nums.length; i++) {
            if(maxReach < i) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach >= nums.length-1) return true;
        }
        return true; // nums.length==0 일 때만 도달.
    }

    // 3. DP (bottom-up)
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        boolean[] dp = new boolean[nums.length];
        // dp[i] 정의 : i 인덱스에서 마지막 인덱스 도달할 수 있는가
        dp[n-1] = true; // 마지막 인덱스에서 마지막 인덱스 도달할 수 있는가 -> 무조건 true

        // dp[i]의 결과를 알려면, dp[i+1], dp[i+2].. 뒤 결과를 알아야 알 수 있음.
        // 따라서 뒤부터 결과를 채움 (마지막 값은 이미 지정했으니 n-2 부터)
        for(int i=n-2; i>=0; i--) {
            // i 에서 최대 점프로 도달할 수 있는 범위 (n 넘지 않게 지정)
            int furthestJump = Math.min(i+nums[i], n);
            for(int j=i+1; j<=furthestJump; j++) {
                if(dp[j]) { // 도달 가능 위치가 이미 true 이면, 현재 위치에서 이미 점프해서 도달한거기 때문에 현재도 true
                    dp[i] = true;
                    break;
                }
            }
            // 도달하지 못한곳은 기본값 false로 남음
        }
        return dp[0]; // 시작점부터 마지막까지 도달가능한지 여부
    }
}