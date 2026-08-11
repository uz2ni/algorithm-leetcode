// 쿠팡 출제 문제
// amount 만드는 최소 동전 개수 구하기 (없으면 -1)
class Solution {
    // 1. 조합 (시간초과)
    public int answer = Integer.MAX_VALUE;
    public int coinChange1(int[] coins, int amount) {
        dfs(coins, amount, 0, 0, 0);
        return (answer == Integer.MAX_VALUE ? -1 : answer);
    }
    public void dfs(int[] coins, int amount, int curAmount, int start, int cnt) {
        if(amount < curAmount) {
            return;
        }
        if(amount == curAmount) {
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i=start; i<coins.length; i++) {
            dfs(coins, amount, curAmount+coins[i], i, cnt+1);
        }
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {                
                if(i - coin >= 0) { // 코인 사용 시 음수 아닐 때만 대상
                    dp[i] = Math.min(dp[i], dp[i-coin]+1); // dp[i-coin]+1 : 코인을 쓰고 남은 금액에 필요한 최소 동전수 + 방금 사용한 코인수1
                } 
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }    
}