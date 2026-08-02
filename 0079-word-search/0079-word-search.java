class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        // board에서 word 만들 수 있는지 반환
        // visited true/false 처리해야 중복 위치 안감

        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                visited[i][j] = true;
                if(dfs(board, word, String.valueOf(board[i][j]), i, j, visited)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, String str, int i, int j, boolean[][] visited) {
        int r = board.length;
        int c = board[0].length;
        
        if(str.equals(word)) {
            return true;
        }
        if(!word.startsWith(str)) {
            return false;
        }
        if(str.length() > word.length()) {
            return false;
        }
        
        for(int k=0; k<4; k++) {
            int nx = dx[k]+i;
            int ny = dy[k]+j;
            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            if(dfs(board, word, str+board[nx][ny], nx, ny, visited)) {
                return true;
            }
            visited[nx][ny] = false;
        }

        return false;
    }
}