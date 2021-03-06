package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * You have 4 cards each containing a number from 1 to 9. 
 * You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:

Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24

Example 2:

Input: [1, 2, 1, 2]
Output: False

Note:

    The division operator / represents real division, not integer division. 
    For example, 4 / (1 - 2/3) = 12.
    Every operation done is between two numbers. 
    In particular, we cannot use - as a unary operator. 
    For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
    You cannot concatenate numbers together. 
    For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class _679_24Game {

    public boolean judgePoint24(int[] nums) {
    	List<Double> list=new ArrayList<>();
    	for(double num:nums) {
    		list.add(num);
    	}
    	return helper(list);
    }
    
    private boolean helper(List<Double> list) {
    	if(list.size()==1) {
    		return Math.abs(list.get(0) - 24) < 1e-6;
    	}
    	
    	for(int i=0;i<list.size();i++) {
    		for(int j=0;j<list.size();j++) {
    			if(i!=j) {
    				List<Double> res4ij=new ArrayList<>();
    				res4ij.add(list.get(i)+list.get(j));
    				res4ij.add(list.get(i)-list.get(j));
    				res4ij.add(list.get(i)*list.get(j));
    				if(list.get(j)!=0)
    					res4ij.add((double)list.get(i)/(double)list.get(j));
    				
    				for(int k=0;k<res4ij.size();k++) {
    					List<Double> newList=new ArrayList<>();
    					for(int l=0;l<list.size();l++) {
    						if(l!=i&&l!=j) {
    							newList.add(list.get(l));
    						}
    					}
    					newList.add(res4ij.get(k));
    					if(helper(newList)) {
    						return true;
    					}
    				}
    			}
    		}
    	}
    	
    	return false;
    }
}
