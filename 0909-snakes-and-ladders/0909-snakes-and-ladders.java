class Solution {
    public int snakesAndLadders(int[][] board) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        return bfs(board, board.length, visited);

    }
    public int bfs(int[][] board, int n, boolean[][] visited) {

        if(n == 1) return 0;

        Queue<int[]> q = new ArrayDeque<>(); // [num,cnt]
        q.offer(new int[]{1,0}); // 시작점
        visited[n-1][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=1; i<=6; i++) { // 주사위 경우의 수 6
                int nxtNum = cur[0] + i;
                int nxtCnt = cur[1] + 1;

                // if (nxtNum > n * n) continue;

                // 뱀/사다리 있으면 먼저 목적지로 치환 (여기서 최종 도착 번호 확정)
                int[] cord = numToXy(n, nxtNum);
                if (board[cord[0]][cord[1]] != -1) {
                    nxtNum = board[cord[0]][cord[1]];
                    cord = numToXy(n, nxtNum);
                }

                // 이제부터는 nxtNum이 "최종 도착 번호" - 체크/삽입 한 곳에서만
                if (nxtNum == n * n) return nxtCnt;

                if (!visited[cord[0]][cord[1]]) {
                    visited[cord[0]][cord[1]] = true;
                    q.offer(new int[]{nxtNum, nxtCnt});
                }
            }
        }

        return -1;
    }

    public int[] numToXy(int n, int num) {
        // 1차 (맨 아래에서 시작하는 위치 구하기)
        int x1 = (num - 1) / n;
        int y1 = (num -1) % n;
        
        // 2차 (실제 좌표로 변환)
        int x = n - 1 - x1;
        int y = (x1 % 2 == 0) ? y1 : (n - 1 - y1);
        
        return new int[]{x, y};
    }
}