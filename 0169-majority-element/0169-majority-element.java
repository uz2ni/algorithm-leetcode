class Solution {
    public int majorityElement(int[] nums) {
        // 다수 요소(배열의 절반보다 많은 요소) 리턴
        // 정렬 후, nums[n/2]
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}