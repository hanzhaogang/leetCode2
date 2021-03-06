package leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a sequence of n integers a1, a2, ..., an, 
 * a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. 
 * Design an algorithm that takes a list of n numbers as input and 
 * checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:

Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.

Example 2:

Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:

Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: 
[-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class _456_132Pattern {
    public boolean find132pattern(int[] nums) {
    /*
     * O(n^3)
     * 
     * Stack
     * 3142
     * 1234
     * -1,3,-2,0
     * 35034
     * -2,1,1
     */
    	List<int[]> set=new ArrayList<>();
    	Deque<Integer> s=new LinkedList<>();
    	int min=nums[0];//-2
    	for(int num:nums) {
    		for(int[] range:set) {
    			if(range[0]<num&&num<range[1])
    				return true;
    		}
    		if(s.isEmpty()||s.peek()<=num) {
    			s.push(num);//{-2,1}
    		}else {
    			if(!s.isEmpty()&&min<num) {
    				return true;
    			}else {
    				int hi=s.peek();
    				int lo=hi;
    				while(!s.isEmpty()) {
    					lo=s.pop();
    				}
    				set.add(new int[] {lo,hi});
    				s.push(num);//{1}
    				min=num;//1
    			}
    		}
    	}
    	
    	return false;
    }
}
