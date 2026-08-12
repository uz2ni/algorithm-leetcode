class Solution {
    // 가장 긴 회문(거꾸로해도 같은) 문자열
    public String longestPalindrome(String s) {
        // 1. DP 에 뭘 담을지 고민 : 문제에서 물어보는 것을 정의 -> 회문에 대한 구간이 필요. (2차원 배열로 표현)
        // 회문은 양끝값을 알아야하기 때문에 1차원적으로 i위치 까지 회문인지 판단할 수 없음.
        // dp[i][j]는 i부터 j까지의 구간이 회문인지 여부 기록
        
        // 2. 점화식 고민 : 가장 바깥 원소를 어떻게 처리할까 (회문의 특성)
        // dp[i][j] = (s[i]==s[j]) && (dp[i+1][j-1])
        // 해석 : 양끝 문자가 같고 양끝 사이의 문자열은 회문이면 dp[i][j]는 true이다.

        // 3. 점화식 초기화 대입
        // dp[i][i] = true (for문으로 하드코딩)
        // dp[i][i+1] = (s[i] == s[i+1]) (for문으로 두 문자 비교해서 대입)

        // 4. 순회 순서 고민
        // dp[i][j] 는 dp[i+1][j-1](더 짧은 구간)에 의존함. (길이1,2는 초기화되어있으니) 길이3부터 dp 채우기
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1; // 최대 길이
        int start = 0; // 시작 인덱스

        // 길이1 dp 초기화 (무조건 회문)
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        // 길이2 dp 초기화
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }

        // 길이3 부터 점화식 수행
        for(int len=3; len<=n; len++) {
            for(int i=0; (i+len-1)<n; i++) { // 시작 범위
                int j = i +len-1; // 끝 범위
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) { // len=3일 때 dp[i+1][j-1] 구간 최대 길이 1임 (이미 정의해둠)
                    dp[i][j] = true;
                    if(len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);
    }
}