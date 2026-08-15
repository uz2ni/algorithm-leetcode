// 섬의 최대 면적
class Solution {
    public int maxArea = 0;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int maxAreaOfIsland(int[][] grid) {
        
        // 면적 모두 체크
        // 방문 시 grid 2 처리 (방문 배열 대체)
        // dfs() 완료 시 maxArea 업데이트
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0 || grid[i][j] == 2) continue;
                int cnt = dfs(grid, m, n, i, j);
                maxArea = Math.max(maxArea, cnt);
            }
        }    

        return maxArea;
    }

    public int dfs(int[][] grid, int m, int n, int x, int y) {
        int sum = 1;
        grid[x][y] = 2;

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            
            if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
            if(grid[nx][ny]==0 || grid[nx][ny]==2) continue;

            sum += dfs(grid, m, n, nx, ny);
        }

        return sum;
    }
}