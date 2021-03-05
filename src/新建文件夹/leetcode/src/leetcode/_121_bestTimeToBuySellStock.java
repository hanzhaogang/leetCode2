package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _121_bestTimeToBuySellStock {
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

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
    public int maxProfit(int[] prices) {
    	//[7,1,5,3,6,4]
    	Deque<Integer> s=new LinkedList<>();
    	int res=0;
    	int min=0;
    	for(int i=0;i<prices.length;i++) {
    		int cur=prices[i];//7,1,5
    		if(s.isEmpty()) {
    			s.push(cur);
    			min=cur;//7
    		}else if(s.peek()<=cur) {
    			if(res<cur-min)
    				res=cur-min;
    			s.push(cur);
    			//min=cur;
    		}else {
    			while(!s.isEmpty()&&cur<s.peek()) {
    				s.pop();
    			}
    			if(s.isEmpty())
    				min=cur;
    			s.push(cur);//1
    			
    		}
    	}
    	return res;
    }
}
