class Solution {
    // stack 이용 문제
    public String simplifyPath(String path) {
        
        // 슬래시(/)로 경로를 쪼개서 검사하면서 stack에 넣고 빼기
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for(int i=0; i<paths.length; i++) {
            if(paths[i].equals("") || paths[i].equals(".")) continue;
            else if(paths[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else stack.push(paths[i]);
        }
       
        if(stack.isEmpty()) return "/";
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, '/'+stack.pop());
        }

        return sb.toString();
    }
}