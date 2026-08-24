class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 첫행, 첫열은 이전 값 누적으로 구함
        dp[0][0] = grid[0][0];
        for(int i=1; i<m; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int j=1; j<n; j++) dp[0][j] = dp[0][j-1] + grid[0][j];
        
        // 나머지 칸은 왼,위 칸 비교해서 구함
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
    public int minPathSum2(int[][] grid) {
        // 경로 기준 : 오른쪽, 아래 방향으로 갈수 없을 때 까지 이동해서 끝나는 경로
        // 리턴 : 최소 경로 값의 합
        // 부분을 기억하면 전체의 일부가 될 수 있나?

        int m = grid.length;
        int n = grid[0].length;
        int[][] memory = new int[m][n];
        for(int i=0; i<memory.length; i++) {
            Arrays.fill(memory[i], Integer.MAX_VALUE);
        }
        memory[0][0] = grid[0][0];
        
        int answer = dp(grid, m, n, 0, 0, memory);
        return answer;
    }
    
    public int dp(int[][] grid, int m, int n, int x, int y, int[][] memory) {
        
        // 범위 벗어나면 리턴
        if(x < 0 || y < 0 || x >= m || y >= n) return 0;
        // 도착점 리턴
        if(x == m-1 && n == n-1) return 
        
        // 점화식 : Math.min(아래 저장값, 오른 저장값)+grid[x][y]
        memory[x][y] = Math.min(dp(grid, m, n, x+1,y, memory), dp(grid, m, n, x, y+1, memory)) + grid[x][y];

        return Math.min(dp(grid, m, n, x, y-1, memory), dp(grid, m, n, x-1, y, memory)) + grid[x][y];
    }
}