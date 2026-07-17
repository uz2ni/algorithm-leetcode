class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return solution(target, nums);
    }

    // 1. 배열 2중 순회 (시간초과)
    public int solution1(int target, int[] nums) {
        int min = 100001;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            int cnt = 0;
            System.out.println(i);
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                cnt++;
                if(sum >= target) {
                    min = Math.min(min, cnt);
                    break;
                }
            }
        }
        return (min == 100001 ? 0 : min);
    }
    // 2. 슬라이딩윈도우 O(N)
    public int solution(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right=0; right<nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                min = Math.min(min, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return (min == Integer.MAX_VALUE ? 0 : min);
    }
}