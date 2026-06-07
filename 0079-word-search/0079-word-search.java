class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int r = board.length;
        int c = board[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(dfs(board, r, c, i, j, visited, word, 0)) {
                   return true; 
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int rx, int cy, int x, int y, boolean[][] visited, String word, int i) {
        if(word.length() == i)  {
            return true;
        }
        if(x < 0 || x >= rx || y < 0 || y >= cy) { // 사방 이동 가능x
            return false;
        }
        if(visited[x][y] || (word.charAt(i) != board[x][y])) { // 현재 위치 방문o, 문자 해당x
            return false;
        }

        visited[x][y] = true;
        
        for(int j=0; j<4; j++) {
            if(dfs(board,rx,cy, x+dx[j], y+dy[j], visited, word, i+1)) {
                return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}
