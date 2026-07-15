class Solution {
    public static List<String> answerList;
    public List<String> letterCombinations(String digits) {
        answerList = new ArrayList<>();

        char[][] chars = {
                            {' '},
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

        recursive(nums, chars, 0, "");

        return answerList;
    }

    public static void recursive(char[] nums, char[][] chars, int depth, String str) {

        if(nums.length == depth) {
            answerList.add(str);
            return;
        }

        int n = nums[depth] - '0';

        for(char c : chars[n]) {
            recursive(nums, chars, depth+1, str+c);
        }
    }
}