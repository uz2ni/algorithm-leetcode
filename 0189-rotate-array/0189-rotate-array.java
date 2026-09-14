class Solution {
    public void rotate(int[] nums, int k) {

        // 1. k가 n개 이상인경우 반복 제거
        int n = nums.length;
        k %= n;
        
        // 2. 전체 뒤집기, 앞구간 다시 뒤집기, 뒷구간 다시 뒤집기
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}