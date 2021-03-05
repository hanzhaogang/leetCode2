package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only 
non-negative integers, 
+, -, *, / operators and 
empty spaces . 

The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5

Note:

    You may assume that the given expression is always valid.
    Do not use the eval built-in library function.
 */
public class _227_basicCalculator2 {
	public static void main(String[] args) {
//		String s=" 3+5 / 2 ";
		String s=" 4- 3+5*3 / 2 ";
		_227_basicCalculator2 solution=new _227_basicCalculator2();
		System.out.println(solution.calculate(s));
	}
	
    public int calculate(String s) {
    	Deque<String> stack=new ArrayDeque<>();
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(c=='+'||c=='-') {
    			stack.push(String.valueOf(c));
    		}else if(Character.isDigit(c)) {
    			int j=i;
    			while(j<s.length()&&Character.isDigit(s.charAt(j))) {
    				j++;
    			}
    			String valStr=s.substring(i,j);
    			stack.push(valStr);
    			i=j-1;
    		}else if(c=='*'||c=='/') {
    			i++;
    			while(' '==s.charAt(i)){
    				i++;
    			}
    			int j=i;
    			while(j<s.length()&&Character.isDigit(s.charAt(j))) {
    				j++;
    			}
    			String valStr=s.substring(i,j);
    			int val=Integer.parseInt(valStr);
    			i=j-1;
    			int popVal=Integer.parseInt(stack.pop());
    			int res=c=='*'?popVal*val:popVal/val;
    			stack.push(String.valueOf(res));
    		}
    	}
    	
    	int res=0;
    	while(!stack.isEmpty()) {
    		String first=stack.peekLast();
    		if(!first.equals("+")&&!first.equals("-")) {
    			res+=Integer.parseInt(stack.pollLast());
    			
    		}else {
    			String op=stack.pollLast();
    			res+=op.equals("-")?
    					0-Integer.parseInt(stack.pollLast()):
    					Integer.parseInt(stack.pollLast());
    		}
    	}
    	return res;
    }
}
