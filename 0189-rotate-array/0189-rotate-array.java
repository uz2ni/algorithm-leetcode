class Solution {
    // 1. 브루트포스. 시간 O(NxK), 공간 O(1) - 시간 초과
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

    // 2. 계산한 각 위치로 이동. 시간 O(N), 공간 O(N) - 통과
    public void rotate2(int[] nums, int k) {
        int[] answers = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int idx = (i+k) % nums.length;
            answers[idx] = nums[i];
        }
        // 복사
        System.arraycopy(answers,0,nums,0,nums.length);
    }

    // 3. 뒤집기. 투포인터 활용. 시간
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        // 1) 전체 뒤집기
        reverse(nums, 0, nums.length-1);
        // 2) 0~k-1 뒤집기
        reverse(nums, 0, k-1);
        // 3) k~length-1 뒤집기
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}