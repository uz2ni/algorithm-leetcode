class Solution {
    public int cnt;
    public int climbStairs(int n) {
        cnt = 0;
        // dfs1(n, 0);
        // System.out.println(cnt);

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        cnt = dp(n, 0, memo);
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

    public int dp(int n, int sum, int[] memo) {
        if(n == sum) return 1; // 현재까지 왔을 때 경우의수 1개 찾은 것 리턴
        if(n < sum) return 0; // 현재 경로는 해답될 수 없음

        if(memo[sum] != -1) return memo[sum];

        memo[sum] = dp(n, sum+1, memo) + dp(n, sum+2, memo);
        return memo[sum];
    }    
}