class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;

        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        while(top <= bottom && left <= right) {
            // 1. top행: 왼쪽 -> 오른쪽
            for(int j=left; j<=right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // 2. right열: 윗 -> 아래
            for(int i=top; i<=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 1,2에서 top, right 값이 바뀌므로, 아래 3,4에서 조건 한번 더 체크

            // 3. bottom행: 오른쪽 -> 왼쪽 (남은 행이 있을 때만)
            if(top <= bottom) {
                for(int j=right; j>=left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 4. left열: 아래 -> 위 (남은 열이 있을 때만)
            if(left <= right) {
                for(int i=bottom; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}