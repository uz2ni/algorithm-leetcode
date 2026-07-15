class Solution {
    public List<String> answerList;
    public List<String> letterCombinations(String digits) {

        if(digits.length()==0) return new ArrayList<>();

        answerList = new ArrayList<>();

        char[][] letters = {
                            {},
                            {},
                            {'a','b','c'},
                            {'d','e','f'},
                            {'g','h','i'},
                            {'j','k','l'},
                            {'m','n','o'},
                            {'p','q','r','s'},
                            {'t','u','v'},
                            {'w','x','y','z'}
                         };
        
        char[] nums = digits.toCharArray();

        recursive(nums, letters, 0, "");

        return answerList;
    }

    public void recursive(char[] nums, char[][] letters, int depth, String str) {

        if(nums.length == depth) {
            answerList.add(str);
            return;
        }

        int n = nums[depth] - '0';

        for(char c : letters[n]) {
            recursive(nums, letters, depth+1, str+c);
        }
    }
}