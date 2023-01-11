class Solution {
    public int maxProfit(int[] prices) {
        int bp=Integer.MAX_VALUE;
        int profit=0;
        for(int i =0;i<prices.length;i++){
            if(bp<prices[i]){
                int prft=prices[i]-bp;
                profit=Math.max(profit,prft);
                
            }else{
                bp=prices[i];
                    
            }
        }
        return profit;
        
    }
}