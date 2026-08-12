class Solution {
    public int uniquePaths(int m, int n) {
        // 아래 또는 오른쪽만 이동 가능
        // 리턴 : 모서리 도달 가능한 고유 경로 수
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return dp(m, n, 0, 0, dp);
    }

    public int dp(int m, int n, int x, int y, int[][] dp) {
        // 그래프 범위 넘어가면 응답
        if(x >= m || y >= n) return 0;

        // 목적지 도착하면 찾은 루트 1 응답
        if(x == m-1 && y == n-1) return 1;

        // dp 존재 시 dp 리턴
        if(dp[x][y] != -1) return dp[x][y];        

        dp[x][y] = dp(m, n, x, y+1, dp) + dp(m, n, x+1, y, dp);
        
        return dp[x][y];
    }
}