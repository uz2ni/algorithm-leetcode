class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl = 0;
        int tl = 0;
        
        while(sl < s.length() && tl < t.length()) {
            if(s.charAt(sl) == t.charAt(tl)) sl++;
            tl++;
        }

        // System.out.println("리턴전 sl: " + sl + ", sr: " + sr + ", tl: " + tl + ", tr: " + tr);
        return sl == s.length() ? true : false;
    }
}