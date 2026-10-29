class Solution {
    public int maxProfit(int[] prices) {
        int curr = prices[0];
        int max = 0;
        
        for(int i = 1 ; i< prices.length ; i++){
            if(prices[i] < curr){
                curr = prices[i];
            }

            int profit = prices[i] - curr;

            if(profit > max){
                 max = profit;
            }
        }
        return max;
    }
}
