class Solution {
    // 공간복잡도 초과 : O(MN)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) continue;
                if(matrix[i][j] != 0) continue;

                // 가로
                for(int ny=0; ny<n; ny++) {
                    int nx = i;
                    if(!visited[nx][ny] && matrix[nx][ny]==0) continue;
                    matrix[nx][ny] = 0;
                    visited[nx][ny] = true;
                }

                // 세로
                for(int nx=0; nx<m; nx++) {
                    int ny = j;
                    if(!visited[nx][ny] && matrix[nx][ny]==0) continue;
                    matrix[nx][ny] = 0;
                    visited[nx][ny] = true;
                }
            }
        }

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}