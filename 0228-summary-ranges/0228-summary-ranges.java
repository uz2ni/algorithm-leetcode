class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answers = new ArrayList<>();

        int left = 0, right = 0;
        while(right < nums.length) {
            // right 다음 이동 가능하고, 연속 구간이라면 -> right++
            if(right+1 < nums.length && (nums[right+1]-nums[right] == 1)) {
                right++;
            }else {
                if(left == right) {
                    answers.add(String.valueOf(nums[left]));
                }else {
                    answers.add(nums[left] + "->" + nums[right]);
                }
                right++;
                left = right;
            }
        }

        return answers;
    }
}