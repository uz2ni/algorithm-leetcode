class Solution {
    // 1. 브루트포스 O(NxK) : 시간 초과
    public void rotate1(int[] nums, int k) {
        int temp = 0;
        k = k % nums.length; // k가 nums보다 크면 여러 바퀴 도는 것을 생략하기 위함
        for(int i=0; i<k; i++) {
            temp = nums[nums.length-1];
            for(int j=nums.length-2; j>=0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    // 2. 계산한 각 위치로 이동. 공간복잡도 O(N)
    public void rotate(int[] nums, int k) {
        int[] answers = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int idx = (i+k) % nums.length;
            answers[idx] = nums[i];
        }
        // 복사
        for(int i=0; i<nums.length; i++) {
            nums[i] = answers[i];
        }
    }
}