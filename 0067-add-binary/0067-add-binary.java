class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1 = a.length()-1;
        int p2 = b.length()-1;

        int carry = 0;

        while(0 <= p1 || 0 <= p2 || carry != 0) {
            int sum = carry;
            if(0 <= p1) sum += a.charAt(p1--) - '0';
            if(0 <= p2) sum += b.charAt(p2--) - '0';
            
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}