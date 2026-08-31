class Solution {
    public String simplifyPath(String path) {

        String[] splitStr = path.split("/");
        StringBuilder sb = new StringBuilder();

        for(String s : splitStr) {
            if(s.equals("..")) {
                // sb에서 뒤에서 첫번째 슬래시까지 삭제 (어떻게 하지?)
                int idx = sb.lastIndexOf("/");
                if(idx != -1) {
                    sb.setLength(idx); // index 부터 잘라냄
                }
            }else if(s.equals(".") || s.equals("")) { // ".", "" 이면 생략
            }else {
                sb.append("/" + s);
            }

        }

        return sb.toString().length() == 0 ? "/" : sb.toString();
        
    }

    public static String simplifyPath2(String path) {
        String[] splitStr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for(String s : splitStr) {
            if(s.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else if(s.equals(".") || s.equals("")) continue;
            else {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            // O(N^2) : 앞에 끼워넣으려면 n번 밀고, n개 반복
            // sb.insert(0, "/"+stack.pop());

            // O(N) : dir 문자열도 뒤집어서 이어붙임, 슬래시도 우측에 붙임
            String dir = stack.pop();
            sb.append(new StringBuilder(dir).reverse()).append("/");
        }
        // 마지막에 정방향으로 전체 뒤집기
        sb.reverse();

        return sb.toString().isEmpty() ? "/" : sb.toString();
    }    
}