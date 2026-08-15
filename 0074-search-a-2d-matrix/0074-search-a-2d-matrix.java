class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        m = 3
        n = 4
        idx = 0 ~ m*n-1
        m*n/2 = 6 -1
        
        idx == 5
        row = idx/n = 5/4 = 1
        col = idx%n = 5%4 = 1
        */

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) left = mid+1;
            else right = mid-1;
        }

        return false;
    }
}