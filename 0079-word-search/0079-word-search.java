class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};

    public boolean exist(char[][] board, String word) {
        // board 에서 이어지는 word가 존재하는지 여부 리턴
        // dfs backtraking
        // word 순서 동일해야함
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                visited[i][j] = true; // 시작칸 방문
                if(dfs(board, word, String.valueOf(board[i][j]), i, j, visited)) {
                    return true;
                }
                visited[i][j] = false; // // 시작칸 복원
            }
        }
        
        return false;
    }

    public boolean dfs(char[][] board, String target, String str, int x, int y, boolean[][] visited) {
        if(target.equals(str)) return true;
        if(!target.startsWith(str)) return false;

        int r = board.length;
        int c = board[0].length;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true; // 이동칸 방문
            if(dfs(board,target, str+board[nx][ny], nx, ny, visited)) {
                return true;
            }
            visited[nx][ny] = false; // 이동칸 복원
        }

        return false;
    }
}