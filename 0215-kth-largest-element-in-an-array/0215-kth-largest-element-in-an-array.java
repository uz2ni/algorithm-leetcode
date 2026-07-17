class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--) {
            if(i == nums.length-k) {
                System.out.println(nums[i]);
                return nums[i];
            }
        }
        return -1;
    }
}