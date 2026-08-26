class Solution {
    // 내 풀이 (일부케이스 시간초과)
    // s.substring, subStr.indexOf(ch) 는 매번 대상 문자열만큼 순회. O(N)이 안됨.
    public int lengthOfLongestSubstring1(String s) {
        int answer = 0;
        int left = 0, right = 0;
        
        while(left <= right && right < s.length()) {
            if(left == right && answer == 0) {
                answer = 1;
                right++;
                continue;
            }
            
            char ch = s.charAt(right);
            String subStr = s.substring(left, right);

            System.out.println("subStr: " + subStr + ", ch: " + ch);
            
            // s(right)가 s[left~right-1] 에 포함되면 중복 존재 -> l++
            if(subStr.indexOf(ch) != -1) { 
                left++;
            }else { // 아니면 -> r++, answer update
                right++;
                if(answer < subStr.length()+1) answer = subStr.length()+1;
            }
        }

        return answer;
    }

    // 정답 풀이
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>(); // O(1) 찾기 가능
        int answer = 0;
        int left = 0;

        for (int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);

            // 문자가 존재하면. left보다 문자 위치가 크거나 같을때, left를 윈도우범위 다음으로 설정
            if(lastIndex.containsKey(ch) && lastIndex.get(ch) >= left) {
                left = lastIndex.get(ch) + 1;
            }

            lastIndex.put(ch, right); // 가장 최근 등장 인덱스로 업데이트
            answer = Math.max(answer, right-left+1);
        }

        return answer;
    }
}