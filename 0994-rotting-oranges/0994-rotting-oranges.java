class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int answer = 0;
        // boolean isStop = false;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        answer = bfs(grid, r, c, q);

        // 썩지 않은 오렌지 있나 체크
        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return answer;
    }

    public int bfs(int[][] grid, int r, int c, Queue<int[]> q) {
        int maxMinute = -1;

        if(q.isEmpty()) return 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();

                for(int j=0; j<4; j++) {
                    int nx = cur[0]+dx[j];
                    int ny = cur[1]+dy[j];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if(grid[nx][ny] != 1) continue;

                    q.offer(new int[]{nx,ny});
                    grid[nx][ny] = 2;
                }
            }
            maxMinute++;
        }
        return maxMinute;
    }
}