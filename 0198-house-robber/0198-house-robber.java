class Solution {
    public int rob1(int[] nums) {
        int k = nums.length-1;
        if(k == 0) return nums[0];
        if(k == 1) {
            return Math.max(nums[0],nums[1]);
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[k];
    }

    public int rob(int[] nums) {
        int k = nums.length-1;
        if(k == 0) return nums[0];
        if(k == 1) {
            return Math.max(nums[0],nums[1]);
        }
        int[] m = new int[nums.length];
        Arrays.fill(m,-1);
        m[0] = nums[0];
        m[1] = Math.max(nums[0],nums[1]);

        return dfs(nums, nums.length-1, m);
    }

    public int dfs(int[] nums, int k, int[] m) {
        if(m[k] != -1) {
            return m[k];
        }

        m[k] = Math.max(dfs(nums, k-1, m), dfs(nums, k-2, m)+nums[k]);
        return m[k];
    }
}