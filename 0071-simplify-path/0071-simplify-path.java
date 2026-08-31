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
}