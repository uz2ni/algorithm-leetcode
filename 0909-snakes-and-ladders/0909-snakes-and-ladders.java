class Solution {
    public int snakesAndLadders(int[][] board) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        return bfs(board, board.length, visited);

    }
    public int bfs(int[][] board, int n, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>(); // [num,cnt]
        q.offer(new int[]{1,0}); // 시작점
        visited[n-1][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println("q 꺼냄 num: " + cur[0] + ", cnt: " + cur[1]);            

            // basecase
            if(cur[0] == n * n) {
                return cur[1];
            }
            
            for(int i=1; i<=6; i++) { // 주사위 경우의 수 6
                int nxtNum = cur[0]+i;
                int nxtCnt = cur[1]+1;
                int[] nxtCord = numToXy(n, nxtNum);

                // 이동 위치가 범위 벗어나면 skip
                if(nxtCord[0] < 0 || nxtCord[1] < 0 || nxtCord[0] >= n || nxtCord[1] >= n) continue;

                // if -1 이고 미방문이라면, 큐 삽입/방문처리
                if((board[nxtCord[0]][nxtCord[1]] == -1)
                    && !visited[nxtCord[0]][nxtCord[1]]) {

                    System.out.println("q 삽입 nxtNum: " + nxtNum + ", nxtCnt: " + nxtCnt);                    
                    q.offer(new int[]{nxtNum, nxtCnt});
                    visited[nxtCord[0]][nxtCord[1]] = true;

                }else if((board[nxtCord[0]][nxtCord[1]] != -1)) {
                    // 이동 번호의 위치 파악
                    nxtNum = board[nxtCord[0]][nxtCord[1]];
                    nxtCord = numToXy(n, nxtNum);
                    
                    // 이동 번호 위치 미방문이라면 큐 삽입/방문 처리
                    if(!visited[nxtCord[0]][nxtCord[1]]) {
                        System.out.println("q 삽입 nxtNum: " + nxtNum + ", nxtCnt: " + nxtCnt);                        
                        q.offer(new int[]{nxtNum, nxtCnt});
                        visited[nxtCord[0]][nxtCord[1]] = true;                        
                    }
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