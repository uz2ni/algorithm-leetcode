class Solution {
    public int findMin(int[] nums) {

        // 중앙값 찾으면서 줄여나가기
        // 중앙값 기준 왼쪽이 작으면 왼쪽 구간 탐색, 오른쪽이 작으면 오른쪽 구간 탐색
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int mid = ((right-left)/2)+left;

            if(nums[mid] > nums[right]) {
                left = mid+1;
            }else {
                right = mid;
            }
        }

        return nums[left];
    }
}
