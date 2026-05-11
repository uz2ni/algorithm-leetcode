class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        int r = grid.length;
        int c = grid[0].length;
        System.out.println("r:" + r + ", c:" + c);
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

        // 상하좌우
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // 이미 방문했으면 continue
            if(visited[cur[0]][cur[1]]) continue;

            visited[cur[0]][cur[1]] = true;

            // 상하좌우에 방문안했고, 1이면 큐 삽입
            for(int k=0; k<4; k++) {
                int nx = cur[1]+dx[k];
                int ny = cur[0]+dy[k];

                if((0 <= nx) && (nx < c) && (0 <= ny) && (ny < r)) {
                    if(!visited[ny][nx] && (grid[ny][nx]=='1')) {
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
        
    }
}
