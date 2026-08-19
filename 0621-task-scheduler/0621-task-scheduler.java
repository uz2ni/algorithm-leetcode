class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // 문자 카운트 저장
        int[] count = new int[26]; // A-Z 카운팅
        for(char c : tasks) {
            count[c - 'A']++;
        }

        // 오름차순 정렬
        Arrays.sort(count);

        // 최빈값, 초기 유휴 슬롯 계산
        int maxCount = count[25]; // 가장 많이 등장한 횟수
        int idleSlots = (maxCount - 1) * n; // maxCount를 가진 동일 알파벳 간의 틈 갯수 * 간격
        
        // 다른 task들로 유휴 슬롯 채우기
        for(int i=24; i>=0; i--) {
            idleSlots -= Math.min(count[i], maxCount-1); // maxCount-1 이유 : 틈 구간에 동일 task 1번만 배치 가능해서
        }

        idleSlots = Math.max(idleSlots, 0); // 음수일수도 있어서 보정.
        // 슬롯 모두 채우고 남을 정도로 다양하다면 idleSlots 음수 가능. 이 경우 유휴 슬롯이 없으므로 총 문자 길이만 리턴
        
        return tasks.length + idleSlots;
    }
}