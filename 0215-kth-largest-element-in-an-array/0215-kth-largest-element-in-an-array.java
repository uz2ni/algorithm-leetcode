class Solution {
    // 1. 정렬 후 구하기
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--) {
            if(i == nums.length-k) {
                System.out.println(nums[i]);
                return nums[i];
            }
        }
        return -1;
    }
    // 2. 최대힙(우선순위큐)으로 삽입 후 k번 뺀 값
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) {
            pq.offer(n);
        }
        for(int i=1; i<=k; i++) {
            if(i == k) {
                return pq.poll();
            }
            pq.poll();
        }
        return -1;
    }
}