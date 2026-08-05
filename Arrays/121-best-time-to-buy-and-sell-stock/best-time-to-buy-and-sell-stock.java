class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0 ;i<prices.length; i++){
            if(minPrice > prices[i] ){
                minPrice = prices[i];
            }
            if((prices[i] - minPrice)>maxPrice){
                maxPrice =(prices[i]-minPrice);
            }
        }
        return maxPrice;
    }
}