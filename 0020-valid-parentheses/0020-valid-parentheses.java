class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty()) {
                char top = stack.peek();
                char c = s.charAt(i);
                if(top == '{' && c == '}') stack.pop();
                else if(top == '[' && c == ']') stack.pop();
                else if(top == '(' && c == ')') stack.pop();
                else stack.push(s.charAt(i));
            }else {
                stack.push(s.charAt(i));
            }
        }

        return (stack.isEmpty() ? true : false);

    }
}