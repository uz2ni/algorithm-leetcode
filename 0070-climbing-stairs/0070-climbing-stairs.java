class Solution {
    public int cnt;
    public int climbStairs(int n) {
        cnt = 0;
        // dfs1(n, 0);
        // System.out.println(cnt);

        // int[] memo = new int[n+1];
        // Arrays.fill(memo, -1);
        // cnt = dp1(n, 0, memo);

        cnt = dp(n);
        return cnt;
    }

    // 시간초과
    public void dfs(int n, int sum) {
        // basecase
        if(n == sum) {
            cnt++;
            return;
        }
        if(n < sum) {
            return;
        }
        dfs(n, sum+1);
        dfs(n, sum+2);
    }

    // top-down (큰문제->작은문제, 재귀+memoization)
    public int dp1(int n, int sum, int[] memo) {
        if(n == sum) return 1; // 현재까지 왔을 때 경우의수 1개 찾은 것 리턴
        if(n < sum) return 0; // 현재 경로는 해답될 수 없음

        if(memo[sum] != -1) return memo[sum];

        memo[sum] = dp1(n, sum+1, memo) + dp1(n, sum+2, memo);
        return memo[sum];
    } 

    // bottom-up (작은문제->큰문제, dp table+for)
    public int dp(int n) {
        if(n <= 2) return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}