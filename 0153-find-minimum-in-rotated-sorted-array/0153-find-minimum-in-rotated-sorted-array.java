class Solution {
    // 1. O(N) 이라 의도와 다름
    // 최악의 경우 전체 탐색이라 중간값 두는 의미가 없음
    public int findMin1(int[] nums) {

        if(nums.length == 1) return nums[0];

        int left = (nums.length/2)-1;
        int right = left+1;
        for(int i=right; i<nums.length; i++) {
            if(nums[left] > nums[i]) return nums[i];
        }

        if(left == 0) return nums[0];

        right = left;
        left = left-1;
        
        while(left >= 0) {
            if(nums[left] > nums[right]) return nums[left+1];
            left--;
        }
        
        return nums[0];
    }

    // 2. O(LogN), 중앙값 두고 분할하면서 정답 찾기
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length-1;
        
        while(left < right) {
            int mid = (right-left)/2 + left;
            if(nums[mid] < nums[right]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }

        return nums[left]; // nums[right] 도 가능
    }
}
