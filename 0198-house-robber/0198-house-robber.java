class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return topDown(nums, 0, memo);
    }

    // 1. idx~마지막 집까지 털 수 있는 최대 금액
    public int topDown(int[] nums, int idx, int[] memo) {
        // 더이상 집이 없는 경우
        if(idx >= nums.length) return 0;

        // 이미 계산한 경우
        if(memo[idx] != -1) return memo[idx];
        
        // 계산 안되어있을 때 다음 구간 계산
        int rob = nums[idx]+topDown(nums, idx+2, memo); // 현재 털 경우
        int skip = topDown(nums, idx+1, memo); // 현재 안털 경우
        memo[idx] = Math.max(rob, skip);
        return memo[idx];
    }
}