class Solution {
    public List<String> answerList;
    public char[][] letters = {
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

    public List<String> letterCombinations(String digits) {

        if(digits.length()==0) return new ArrayList<>();

        answerList = new ArrayList<>();

        backtrack(digits, "");

        return answerList;
    }

    public void backtrack(String digits, String str) {
        int index = str.length();
        if(digits.length() == index) {
            answerList.add(str);
            return;
        }

        int n = digits.charAt(index) - '0';

        for(char c : letters[n]) {
            backtrack(digits, str+c);
        }
    }
}