/*
 * Say you have an array for which the ith element is the price of a given stock 
 * on day i.

If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to find 
the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class LC0121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		/*
		 * 1. brute force
		 * TC:O(n^2)
		 * 
		 * 2. 
		 * in the first loop, we get the largest future value for each price.
		 * in the second loop, we calculate the max profit for buying stock today
		 * 
		 * TC:O(n)
		 * SC:O(n)
		 */
		
		if(prices==null||prices.length==0||prices.length==1) 
			return 0;
		
		int[] maxFuPrs=new int[prices.length+1];
		
		for(int i=prices.length-1;0<=i;i--) {
			if(maxFuPrs[i+1]<prices[i]) {
				maxFuPrs[i]=prices[i];
			}else {
				maxFuPrs[i]=maxFuPrs[i+1];
			}
		}
		
		int maxPro=0;
		for(int i=0;i<prices.length;i++) {
			if(maxPro<maxFuPrs[i]-prices[i])
				maxPro=maxFuPrs[i]-prices[i];
		}
		return maxPro;
    }

    //find indexes for region from 0 to hiIndx.
    /*public int[] helper(int[] prices,int hiIndx){
        int[] indxs=new int[2];
        
        if(hiIndx==1){
            if(0<prices[1]-prices[0]){
                indxs[0]=0;
                indxs[1]=1;
                return indxs;
            }else{
                indxs[0]=0;
                indxs[1]=0;
                return indxs;
            }
                
        }
            
        int[] preIndxs=helper(prices,hiIndx-1);
        if(preIndxs[1]==hiIndx-1){
            if(prices[hiIndx-1]<=prices[hiIndx]){
                indxs[0]=preIndxs[0];
                indxs[1]=hiIndx;
            }else{
                return preIndxs;
            }
        }else{
            int min=Integer.MAX_VALUE;
            int minPricesIndx=-1;
            for(int i=0;i<hiIndx;i++){
                if(prices[i]<min){
                    min=prices[i];
                    minPricesIndx=i;
                }
                
            }
            if(prices[preIndxs[1]]-prices[preIndxs[0]]<prices[hiIndx]-min){
                indxs[0]=minPricesIndx;
                indxs[1]=hiIndx;
            }else
                return preIndxs;
        }
        
        return indxs;
    }*/
}
