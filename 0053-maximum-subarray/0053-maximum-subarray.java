class Solution {
    // 2차원 DP (시간초과)
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        
        // 길이 1 초기화
        for(int i=0; i<n; i++) {
            dp[i][i] = nums[i];
            max = Math.max(max, dp[i][i]);
        }

        for(int len=2; len<=n; len++) {
            for(int j=n-1; j>=len-1; j--) { // 거꾸로 순회, j는 끝값
                int i = (j-len+1); // 시작값
                // 시작~끝전 까지는 이미 있음
                // 시작~끝전 + nums[j] = dp에 담기
                dp[i][j] = dp[i][j-1] + nums[j];
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i=1; i<n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}