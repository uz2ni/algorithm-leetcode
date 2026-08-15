class Solution {
    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};
    public boolean isSide; // 가장자리 여부
    boolean[][] visited; // 방문처리 관리
    public void solve(char[][] board) {
        // 전체 셀 체크해야함
        // 연결된 셀 체크 중에 "가장자리 닿는 셀" 존재하면 "연결된 영역" 모두 X처리
        // -> 현재 시점에 이동중인 셀 기록(X처리용), 전체용 visited 처리, 둘러싸임 아닌 경우(가장자리) true 처리, 순회 후 false인 경우 기록된 셀 X처리

        int m = board.length;
        int n = board[0].length;

        Queue<int[]> history; // 이동 셀 기록 (X처리용)
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(board[i][j] == 'X' || visited[i][j]) continue;

                history = new ArrayDeque<>();
                isSide = false;

                dfs(board, history, visited, m, n, i, j);

                if(!isSide) { // history 꺼내서 O 처리
                    int[] h;
                    while(!history.isEmpty()) {
                         h = history.poll();
                         board[h[0]][h[1]] = 'X';
                    }
                }
            }
        }
    
    }

    public void dfs(char[][] board, Queue<int[]> history, boolean[][] visited, int m, int n, int x, int y) {
        
        visited[x][y] = true;
        
        if(checkSide(m, n, x, y)) {
            isSide = true;
        }

        if(!isSide) {
            history.offer(new int[]{x, y});
        }

        for(int i=0; i<4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue; // 범위밖이면 continue
            if(board[nx][ny] == 'X' || visited[nx][ny]) continue; // 'X' 이거나 방문했으면 continue    
            
            dfs(board, history, visited, m, n, nx, ny);
        }
    }

    public boolean checkSide(int m, int n, int x, int y) {
        if(x == 0 || y == 0 || x == m-1 || y == n-1) {
            return true;
        }
        return false;
    }
}