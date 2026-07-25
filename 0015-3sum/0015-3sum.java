class Solution {
    // 코드 이해 잘 안됨..
    
    public List<List<Integer>> threeSum(int[] nums) {
        // 3개 골랐을 때 합이 0이 되는 조합 반환
        Arrays.sort(nums);                          // ① 정렬 필수
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // ② 고정값 중복 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // ③ 가지치기: 최솟값이 양수면 세 수 합은 절대 0 불가
            if (nums[i] > 0) break;

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // ④ 두 포인터 각각의 중복 건너뛰기
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;                         // 합이 작다 → 큰 값 쪽으로
                } else {
                    right--;                        // 합이 크다 → 작은 값 쪽으로
                }
            }
        }
        return result;        
    }
}