class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    // 틀린 코드. 문제 잘못 이해 (1위치 1칸씩 2개만 존재하는줄 알았던 코드..)
    public int shortestBridge1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // start, end 찾기
        int sx=-1, sy=-1, ex=-1, ey=-1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    if(sx==-1) {
                        sx = i;
                        sy = j;
                    }else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        // start->end 가장 짧은 길이 탐색
        int length = bfs1(grid, m, n, sx, sy, ex, ey);
        return length;
    }

    public int bfs1(int[][] grid, int m, int n, int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println("cur: " + cur[0] + ", " + cur[1] + ", " + cur[2]);
            
            if(cur[0] == ex && cur[1] == ey) {
                return cur[2]-1;
            }

            for(int i=0; i<4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || ny<0 || nx>=m || ny>=n) continue; // 범위 밖
                if(visited[nx][ny]) continue; // 방문인 경우

                q.offer(new int[]{nx, ny, cur[2]+1});
                visited[nx][ny] = true;
            }
        }

        return 0;
    }

    public int shortestBridge(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        
        // dfs로 시작 섬들 큐에 삽입
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(q.isEmpty() && (grid[i][j] == 1)) {
                    dfs(grid, m, n, i, j, q, visited);
                }
            }
        }

        // 큐에서 뽑으면서 length 늘리기, 방문 안한 1 만나면 length 리턴
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // if(grid[cur[0]][cur[1]]==1) {
            //     return cur[2];
            // }

            for(int i=0; i<4; i++) {
                int nx = dx[i]+cur[0];
                int ny = dy[i]+cur[1];
                
                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                if(visited[nx][ny]) continue;
                
                if(grid[nx][ny] == 0) {
                    q.offer(new int[]{nx,ny,cur[2]+1});
                    visited[nx][ny] = true;
                }else { // 새로운 1 발견
                    
                    return cur[2];

                }                
            }
        }
        return 0;
    }

    public void dfs(int[][] grid, int m, int n, int x, int y, Queue<int[]> q, boolean[][] visited) {

        visited[x][y] = true;
        q.offer(new int[]{x,y,0});

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            
            if(nx<0 || ny<0 || nx>=m || ny>=n) continue; // 범위 밖
            if(visited[nx][ny] || grid[nx][ny]==0) continue; // 이미 방문했거나 0
            
            dfs(grid, m, n, nx, ny, q, visited);
        }
        
    }
}