class Solution {
    public List<String> answers;
    public List<String> restoreIpAddresses(String s) {
        answers = new ArrayList<>();
        dfs(s, 0, 0, new ArrayList<>());
        return answers;
    }

    public void dfs(String s, int index, int count, List<String> path) {
        if(count == 4 && index == s.length()) {
            String answer = "";
            for(int i=0; i<path.size(); i++) {
                if(i == 0) {
                    answer += path.get(i);
                }else {
                    answer += ("." + path.get(i));
                }
            }
            answers.add(answer);
            return;
        }

        for(int i=1; i<=3; i++) { // 한 구간의 문자 길이 1~3
            if(index+i > s.length()) break;

            String subPath = s.substring(index,index+i);
            
            // leading zero 검사 (길이 1개 초과인데 맨앞 0이면 X)
            if(subPath.length()>1 && subPath.charAt(0)=='0') break;

            // 가능한 숫자 범위 검사
            if(Integer.parseInt(subPath) > 255) break;

            path.add(subPath);
            dfs(s, index+i, count+1, path);
            path.remove(path.size()-1);
        }
    }
}