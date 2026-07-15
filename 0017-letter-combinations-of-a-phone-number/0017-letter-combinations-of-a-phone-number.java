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

        recursive(digits, letters, "");

        return answerList;
    }

    public void recursive(String digits, char[][] letters, String str) {
        int length = str.length();
        if(digits.length() == length) {
            answerList.add(str);
            return;
        }

        int n = digits.charAt(length) - '0';

        for(char c : letters[n]) {
            recursive(digits, letters, str+c);
        }
    }
}