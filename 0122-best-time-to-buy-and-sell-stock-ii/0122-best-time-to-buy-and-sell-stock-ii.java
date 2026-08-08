class Solution {
    public int maxProfit(int[] prices) {
        // minPrice = 높->낮 이면 업데이트
        // minPrice = 낮->높 이면 현재-전 이익 add
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(minPrice < prices[i]) {
                maxProfit += (prices[i]-prices[i-1]);
                minPrice = prices[i];
            }else {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}