class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid = left + (right-left)/2;
        
        while(left < right) { // left == right 일 때 중단됨
            if(nums[mid] < nums[mid+1]) {
                left = mid+1;
            }else { // nums[mid] > nums[mid+1] 인 상황 (서로 같은 값인 경우는 조건 상 없음)
                right = mid; // mid가 최고점일수도 있으므로 범위에 포함
            }
            mid = left + (right-left)/2;
        }

        return left; // left=right 동일
    }
}