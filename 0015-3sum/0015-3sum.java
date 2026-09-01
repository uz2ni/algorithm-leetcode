class Solution {
    // set/map 방식도 해보기

    // 투포인터 방식
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) { // length-2인 이유 : i위치 뒤에 2개를 골라야해서 i가 최대로 갈 수 있는 위치임

            if(nums[i]>0) continue; // 첫선택값이 양수이면 뒤는 더 큰 수 뿐이라 합산 0 나올 수 없음
            if(i>0 && nums[i] == nums[i-1]) continue; // 이전 위치와 값이 같다면 케이스가 중복이라 skip (i>0인 이유 : i-1 가 최소 0이어야해서)

            int target = -nums[i];
            int left = i+1, right = nums.length-1;

            while(left < right) {

                int sum = nums[left] + nums[right];

                if(target == sum)  {

                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // 중복 케이스 skip
                    while(left<right && nums[left] == nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1]) right--;


                // 아래 조건에서는 정답에 영향 없어서 중복 skip 없어도 됨
                }else if(target > sum) {
                    left++;
                }else {
                    right--;
                }
            }
        }

        return answer;       
    }
}