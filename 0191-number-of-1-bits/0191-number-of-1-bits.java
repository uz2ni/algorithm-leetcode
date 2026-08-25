class Solution {
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0; i<binary.length(); i++) {
            int num = binary.charAt(i) - '0';
            if(num == 1) cnt++;
        }
        return cnt;
    }
}