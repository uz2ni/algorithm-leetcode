class Solution {
    public String reverseWords(String s) {
        String[] keywords = s.trim().split(" ");
        String answer = "";
        for(int i=keywords.length-1; i>=0; i--) {
            if(keywords[i].equals("")) continue;
            answer += (keywords[i] + " ");
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    } 
}