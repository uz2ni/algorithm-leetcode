class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 아예 불가능한 경우 처리
        int sum = 0;
        for(int i=0; i<gas.length; i++) {
            sum += gas[i];
            sum -= cost[i];
        }
        if(sum < 0) return -1;

        
        sum = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++) {
            sum += gas[i] - cost[i];

            // 합산 음수 의미 : start로 설정한 인덱스에서 현재 지점까지 합산이 음수이므로 시작 위치가 될 수 없음
            if(sum < 0) {
                sum = 0;
                start = i+1;
            }
        }

        return start;
    }
}