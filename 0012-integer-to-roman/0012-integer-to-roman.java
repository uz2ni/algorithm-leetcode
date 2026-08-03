class Solution {
    public String intToRoman(int num) {
        // 1. 뺄셈 표기 포함해 큰수부터 정렬 (어차피 고정 문자라 알고리즘으로 문자 구하는게 아님)
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        // 2. num이 값보다 작아질때까지 빼면서 symbols 이어붙임
        for(int i=0; i<values.length; i++) {
            while(num >= values[i]) {
                sb.append(symbols[i]);
                num-=values[i];
            }
        }
    
        return sb.toString();
    }
}