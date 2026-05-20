class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 가장 빈번한 수 k개
        Map<Integer,Integer> map = new HashMap<>();
        int[] answer = new int[k];

        // nums 돌면서 list에(num,개수) 넣기
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        // map to list
        List<int[]> list = new ArrayList<>(); // [x]=[key,size],..
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }

        // 정렬
        list.sort((l1, l2) -> {
            return l2[1]-l1[1];
        });

        for(int i=0; i<k; i++) {
            int[] target = list.get(i);
            answer[i] = target[0];
        }

        return answer;
    }
}
