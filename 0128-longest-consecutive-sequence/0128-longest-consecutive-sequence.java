import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        // 정렬 후 연속순서 최대길이 리턴
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        for(int s : set) {
            if(!set.contains(s-1)) {
                int cur = s;
                int length = 1;
                
                while(set.contains(cur+1)) {
                    cur++;
                    length++;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    }
}