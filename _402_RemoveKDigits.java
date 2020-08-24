package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is the smallest possible.

Note:

    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

Example 1:

Input: num = "1432219", k = 3; 1432291
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. 
Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */
public class _402_RemoveKDigits {
	public static void main(String[] args) {
		_402_RemoveKDigits s=new _402_RemoveKDigits();
//		String num="1432219";
//		int k = 3;
//		String num="10";
//		int k = 1;
		String num="100000000009";
		int k=5;
		System.out.println(s.removeKdigits(num, k));
	}
    public String removeKdigits(String num, int k) {//10,1
    	if(num.length()==k)
    		return "0";
    	Deque<Character> stack=new ArrayDeque<>();
    	StringBuilder sb=new StringBuilder();
    	for(char c:num.toCharArray()) {
    		if(k==0||stack.isEmpty()) {
    			stack.push(c);
    		}else {
    			while(0<k&&//note k since is changed in the loop
    					!stack.isEmpty()&&c<stack.peek()) {
    				stack.pop();
    				k--;
    			}
    			stack.push(c);
    		}
    	}
    	
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
    	sb.reverse();
    	int index=0;
    	while(0<sb.length()&&sb.charAt(index)=='0') {
    		sb.deleteCharAt(index);
    	}
    	
    	if(sb.length()==0)
    		return "0";
    	if(0<k) {
    		String res=sb.toString().substring(0,Math.max(0, sb.length()-k));
    		if(res.length()==0)
    			return "0";
    		else {
    			return res;
    		}
    	}else {
    		return sb.toString();//1234567 k=2
    	}
    }
}
