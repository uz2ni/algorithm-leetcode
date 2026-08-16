// 두 서버가 같은 열 혹은 행이면 커뮤케이션 가능
// 커뮤니케이션 가능한 서버 수 반환
// idea : dfs/bfs로 전체 위치 체크. 현위치에서 상하좌우 이동 가능한 셀 있다면 카운팅
class Solution {
    public int cnt = 0;
    public int subCnt = 0;
    
    // 1. 그래프 탐색(dfs선택) 방식 (통과)
    public int countServers1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if(visited[i][j] || grid[i][j]==0) continue;

                subCnt = 0;
                dfs(grid, m, n, i, j, 0, visited); // direction(상위 셀의 탐색 방향) : 0(없음), 1(row), 2(col)
                
                if(subCnt > 1) {
                    cnt += subCnt;
                }
            }
        }
        return cnt;
    }

    public void dfs(int[][] grid, int m, int n, int x, int y, int direction, boolean[][] visited) {
        
        subCnt++;
        visited[x][y] = true;

        if(direction == 1 || direction == 0) { // col 탐색
            int nx;
            int ny = y;
            for(int i=0; i<m; i++) {
                nx = i;
                if(visited[nx][ny] || grid[nx][ny]==0) continue;
                dfs(grid, m, n, nx, ny, 2, visited);
            }
        }
        
        if(direction == 2 || direction == 0) { // row 탐색
            int nx = x;
            int ny;
            for(int i=0; i<n; i++) {
                ny = i;
                if(visited[nx][ny] || grid[nx][ny]==0) continue;
                dfs(grid, m, n, nx, ny, 1, visited);
            }
        }
    }

    // 2. 동일 행/열 서버 카운팅 방식
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        int cnt = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && (rowCount[i]>1 || colCount[j]>1)) {
                    cnt++;
                }
            }
        }       

        return cnt; 
    }
}