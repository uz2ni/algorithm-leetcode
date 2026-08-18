class Solution {
    public List<Integer> answer = new ArrayList<>();
    public List<Integer> majorityElement(int[] nums) {
        // map에 +1 넣기
        // n/3 이상(초과?) 이면 list add
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if(count == (nums.length/3)+1) {
                answer.add(num);
            }
        }

        return answer;
    }
}