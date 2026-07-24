class Solution {
    public List<String> summaryRanges(int[] nums) {
        // 연속 구간이면 묶어서 반환(3->5), 하나뿐이면 숫자만 반환(1)
        // 0,1,2,4,5,7 : 0->2, 4->5, 7

        List<String> answers = new ArrayList<>();
        List<Integer> temps = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            if(temps.size() == 0) {
                temps.add(nums[i]);
            }
            
            else if((temps.get(temps.size()-1)+1) == nums[i]) {
                temps.add(nums[i]);
            }
            
            else {
                if(temps.size() == 1) { 
                    answers.add(String.valueOf(temps.get(0)));
                    temps.clear();
                    temps.add(nums[i]);
                }else {                    
                    String str = temps.get(0) + "->" + temps.get(temps.size()-1);
                    answers.add(str);
                    temps.clear();
                    temps.add(nums[i]);
                }
            }
        }

        if(!temps.isEmpty()) {
            if(temps.size() == 1) {
                answers.add(String.valueOf(temps.get(0)));
            }else {
                    String str = temps.get(0) + "->" + temps.get(temps.size()-1);
                    answers.add(str);
            }
        }

        return answers;
    }
}