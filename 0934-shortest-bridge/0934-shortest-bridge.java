class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};

    public int shortestBridge(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean isFirstIsland = false;
        for(int i=0; i<r; i++) {
            if(isFirstIsland) break;

            for(int j=0; j<c; j++) {
                if(isFirstIsland) break;

                if(grid[i][j] == 1) {
                    isFirstIsland = true;
                    dfs(grid, i, j, r, c, q);
                }
            }
        }
        return bfs(grid, r, c, q);
    }

    // 처음 방문한 섬으로 이룬 모든 셀 큐에 넣고 2로 변경
    public void dfs(int[][] grid, int x, int y, int r, int c, Queue<int[]> q) {

        q.offer(new int[]{x,y});
        grid[x][y] = 2;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if(grid[nx][ny] != 1) continue;
            dfs(grid, nx, ny, r, c, q);
        }
    }

    public int bfs(int[][] grid, int r, int c, Queue<int[]> q) {
        int cnt = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                // 큐에서 하나 꺼내서
                int[] cur = q.poll();

                // 사방으로 가능한 셀 큐에 삽입
                for(int j=0; j<4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if(grid[nx][ny] == 2) continue;
                    if(grid[nx][ny] == 1) return cnt;

                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }
            }

            cnt++;
        }

        return -1;
    }
}