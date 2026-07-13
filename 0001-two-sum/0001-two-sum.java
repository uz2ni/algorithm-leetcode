class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 두 숫자의 합이 target
        // return: 합이되는 두 숫자의 인덱스

        int[] answer = new int[2];

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}