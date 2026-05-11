class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(!visited[i][j] && (grid[i][j]=='1')) {
                    bfs(grid, i, j, r, c, visited);
                    answer++;
                }
            }
        }
        
        return answer;
    }

    public void bfs(char[][] grid, int i, int j, int r, int c, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;

        // 상하좌우
        int[] dc = {0,0,-1,1};
        int[] dr = {-1,1,0,0};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            // 상하좌우에 방문안했고, 1이면 큐 삽입
            for(int k=0; k<4; k++) {
                int nc = cur[1]+dc[k];
                int nr = cur[0]+dr[k];

                if((0 <= nc) && (nc < c) && (0 <= nr) && (nr < r)) {
                    if(!visited[nr][nc] && (grid[nr][nc]=='1')) {
                        q.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
    }
}
