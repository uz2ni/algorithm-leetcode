class Solution {
    public boolean isValid(String s) {
               
        if((s.length() % 2) == 1) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(')');
            else if(s.charAt(i) == '{') stack.push('}');
            else if(s.charAt(i) == '[') stack.push(']');
            else {
                if(stack.isEmpty()) return false;
                if(s.charAt(i) != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}