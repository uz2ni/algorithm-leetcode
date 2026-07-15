// 풀이 시간 : 20m
class Solution {
    public int cnt;
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        cnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(visited[i][j] || (grid[i][j] == '0')) continue;
                dfs(grid, visited, grid.length, grid[0].length, i, j);
                cnt++;    
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, boolean[][] visited, int m, int n, int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(visited[nx][ny] || (grid[nx][ny] == '0')) continue;
            dfs(grid, visited, m, n, nx, ny);
        }
    }
}