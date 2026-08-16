// 인접한 셀의 높이가 현재 셀보다 작거나 같으면 -> 물흐를 수 있음
// 바다 인접한 셀은 -> 바다로 물 흐를 수 있음
// 해당 셀에서 태평양,대서양 모두 흐를 수 있는 좌표 반환

// 셀마다 각 바다까지 흐를 수 있는지 체크해야함

// 바다 인접 체크 관리 : boolean[2] adj // [x,y] pacific, atlantic 모두 true 이면 인접
// 두값 모두 true 되면 탐색 중단, 반환리스트 삽입

// 셀 별 순회마다 visited 생성, 처리
// 셀 별 순회마다 Queue 생성, 처리

// dfs, bfs 상관없음(?)

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    List<List<Integer>> answers = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[0].length; j++) {
                if(bfs(heights, i, j)) {
                    continue;
                }
                
            }
        }
        return answers;
    }

    public boolean bfs(int[][] heights, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[] adj = new boolean[2]; // pacific, atlantic 인접해는지 여부

        q.offer(new int[]{x, y, heights[x][y]});
        visited[x][y] = true;
        // 바다 인접한지 체크, 바다 모두 인접하면 리스트 넣고 return
        adjOceanCheck(adj, m, n, x, y);
        if(adj[0] && adj[1]) {
            List<Integer> list = new ArrayList<>(List.of(x, y));
            answers.add(list);
            return true;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = dx[i]+cur[0];
                int ny = dy[i]+cur[1];
                
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue; // 영역 밖이면 continue
                if(visited[nx][ny] || (heights[nx][ny] > cur[2])) continue; // 이미 방문했거나 현재높이보다 높으면 continue

                // 바다 인접 체크, 양쪽 바다 인접 여부 리턴
                adjOceanCheck(adj, m, n, nx, ny);
                if(adj[0] && adj[1]) {
                    List<Integer> list = new ArrayList<>(List.of(x, y));
                    answers.add(list);
                    return true;
                }

                // 큐 삽입 & vistied 처리
                q.offer(new int[]{nx, ny, heights[nx][ny]});
                visited[nx][ny] = true;
            }
        }
        
        return false;
    }

    public void adjOceanCheck(boolean[] adj, int m, int n, int x, int y) {
    // pacific 인접셀 조건 : 0,0~0,(n-1) or 0,0~(m-1),0 -> [0] true
    // atlantic 인접셀 조건 : (m-1),0~(m-1),(n-1) or 0,(n-1)~(m-1),(n-1) -> [1] true

        // pacific 인접셀 여부 처리
        if(x == 0) {
            for(int i=0; i<n; i++) {
                if(i == y) {
                    adj[0] = true;
                    break;
                }
            }
        }else if(y == 0) {
            for(int i=0; i<m; i++) {
                if(i == x) {
                    adj[0] = true;
                    break;
                }
            }
        }

        // atlantic 인접셀 여부 처리
        if(x == m-1) {
            for(int i=0; i<n; i++) {
                if(i == y) {
                    adj[1] = true;
                    break;
                }
            }
        }else if(y == n-1) {
            for(int i=0; i<m; i++) {
                adj[1] = true;
                break;
            }
        }
    }
}