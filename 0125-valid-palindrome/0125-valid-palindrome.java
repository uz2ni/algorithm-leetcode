class Solution {
    public boolean isPalindrome2(String s) {
        // 영숫자 이외 문자 제거, 앞뒤 읽었을 때 내용 동일해야 함
        
        // 1. 소문자 변환, 비대상 문자 제거
        String cleanS = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 2. String to char[]
        char[] chs = cleanS.toCharArray();

        // 3. 내용 동일 체크
        int left = 0;
        int right = chs.length-1;
        while(left < right) {
            if(chs[left] != chs[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // [개선] toCharArray() 없이 String 에서 바로 비교
    public boolean isPalindrome(String s) {
        // 영숫자 이외 문자 제거, 앞뒤 읽었을 때 내용 동일해야 함
        
        // 1. 소문자 변환, 비대상 문자 제거
        String cleanS = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 3. 내용 동일 체크
        int left = 0;
        int right = cleanS.length()-1;
        while(left < right) {
            if(cleanS.charAt(left) != cleanS.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }    
}
