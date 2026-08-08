class Solution {
    // 내 풀이 - 성공 / 시간초과
    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i=0; i<prices.length; i++) {
            int subMax = 0;
            for(int j=i; j<prices.length; j++) {
                if(prices[i]<prices[j]) {
                    subMax = Math.max(subMax, prices[j]-prices[i]);
                }
            }
            max = Math.max(max, subMax);
        }
        return max;
    }

    // O(N) 최저가, 최고이익금액을 찾음
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(minPrice < prices[i]) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }else {
                minPrice = Math.min(minPrice, prices[i]);
            }
        }
        return maxProfit;
    }
}