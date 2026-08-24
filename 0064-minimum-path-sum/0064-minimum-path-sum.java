class Solution {
    // bottom-up
    public int minPathSum2(int[][] grid) {
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
    
    // top-down
    public int minPathSum(int[][] grid) {
        // 경로 기준 : 오른쪽, 아래 방향으로 갈수 없을 때 까지 이동해서 끝나는 경로
        // 리턴 : 최소 경로 값의 합
        // 부분을 기억하면 전체의 일부가 될 수 있나?
        int m = grid.length;
        int n = grid[0].length;
        int[][] memory = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(memory[i], -1);
        }
        return dp(grid, m-1, n-1, memory);
    }
    
    public int dp(int[][] grid, int x, int y, int[][] memory) {
        
        // 범위 벗어나면 리턴 (점화식(최소값찾기)에서 선택 안되도록 큰값 지정)
        if(x < 0 || y < 0) return Integer.MAX_VALUE;
        // 시작점 리턴
        if(x == 0 && y == 0) return grid[0][0];
        // 계산된 값
        if(memory[x][y] >= 0) return memory[x][y];
        
        // 점화식 : Math.min(왼, 위)+grid[x][y]
        memory[x][y] = Math.min(dp(grid, x, y-1, memory), dp(grid, x-1, y, memory)) + grid[x][y];
        
        return memory[x][y];
    }
}