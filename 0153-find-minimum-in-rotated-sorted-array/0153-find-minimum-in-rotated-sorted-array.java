class Solution {
    public int findMin(int[] nums) {

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
}
