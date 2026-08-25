class Solution {
    // 메모리 O(1), 시간 O(N) 필요
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            // 있으면 revove
            if(set.contains(nums[i])) {
               set.remove(nums[i]);
            }else { // 없으면 add
                set.add(nums[i]); 
            }
        }

        for(int x : set) {
            return x;
        }
        
        return -1;
    }
}