package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given a list of daily temperatures T, return a list such that, for each day in the input, 
 * tells you how many days you would have to wait until a warmer temperature. 
 * If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. 
Each temperature will be an integer in the range [30, 100]. 
 */
public class _739_dailyTemp {
    public int[] dailyTemperatures(int[] T) {
    	int[] res=new int[T.length];
    	
    	Deque<Integer> s=new ArrayDeque<>();
    	for(int i=0;i<T.length;i++) {
    		if(s.isEmpty()) {
    			s.push(i);
    		}else {
    			int topIndex=s.peek();
    			if(T[i]<=T[topIndex]) {
    				s.push(i);
    			}else {
    				while(!s.isEmpty()&&T[s.peek()]<T[i]) {
    					int topIndex2=s.pop();
    					res[topIndex2]=i-topIndex2+1;
    				}
    				s.push(i);
    			}
    		}
    	}
    	
    	return res;
    }
}
