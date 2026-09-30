class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answers = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> answer = new HashSet<>(); // 중복 답안 거르기 위해 다시 Set에 넣음

        for(int i=0; i<=s.length()-10; i++) {
            String subStr = s.substring(i, i+10);
            if(!seen.add(subStr)) {
                answer.add(subStr);
            }
        }

        for(String a : answer) {
            answers.add(a);
        }

        return answers;
    }
}