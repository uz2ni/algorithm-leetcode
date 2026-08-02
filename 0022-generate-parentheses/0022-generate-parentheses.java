class Solution {
    public List<String> answers = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return answers;
    }

    public void dfs(int n, String str, int open, int close) {
        if(open < close || (str.length() > n*2)) {
            return;
        }
        if(open == n && close == n) {
            answers.add(str);
            return;
        }

        dfs(n, str+"(", open+1, close);
        dfs(n, str+")", open, close+1);
    }
}