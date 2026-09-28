class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) { // 겹치는 마지막 원소도 검사를 해야해서
            int mid = left + (right-left)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) { // 왼쪽 구간이 정렬 && 범위에 target 들어간다면, 왼쪽 다시 탐색
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                }else {
                    right = mid-1;
                }                
            }
        }

        return -1;
    }
}