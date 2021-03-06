package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain 
open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2

Example 2:

Input: " 2-1 + 2 "
Output: 3

Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:

    You may assume that the given expression is always valid.
    Do not use the eval built-in library function.
 */
public class _224_basicCalculator {
	public static void main(String[] args) {
		_224_basicCalculator solution=new _224_basicCalculator();
//		String s="(1+(4+5+2)-3)+(6+8)";
//		String s="1 + 1";
//		String s=" 2-1 + 2 ";
//		"2-(5-6)"
		String s="(5-(1+(5)))";
		System.out.println(solution.calculate(s));
	}
    public int calculate(String s) {
    	//return helper(s,0,s.length()-1);
    	Deque<String> stack=new ArrayDeque<>();
    	String exp="("+s+")";//((1+(4+5+2)-3)+(6+8))//( ( 5 - ( 1 + 5)))
    	for(int i=0;i<exp.length();i++) {
    		char c=exp.charAt(i);
    		if(c=='(') {
    			stack.push(Character.toString(c));
    		}else if(c=='+'||c=='-') {
    			stack.push(Character.toString(c));
    		}else if(Character.isDigit(c)) {
    			int j=i;
    			while(Character.isDigit(exp.charAt(j))){
    				j++;
    			}
    			stack.push(exp.substring(i,j));
    			i=j-1;
    		}else if(c==')') {
    			int temp=0;
    			while(!stack.isEmpty()&&!stack.peek().equals("(")) {
    				String valueStr=stack.pop();
    				String opStr="";
    				if(!stack.isEmpty()&&!stack.peek().equals("(")) {
    					opStr=stack.pop();
    				}
    				if(valueStr.charAt(0)=='-') {
    					if(opStr.equals("+")||opStr.equals(""))
    						temp+=Integer.parseInt(valueStr);
    					else if(opStr.equals("-"))
    						temp-=Integer.parseInt(valueStr);
    					
    						
    				}else
    					temp+=Integer.parseInt(opStr+valueStr);//5
    			}
    			if(!stack.isEmpty()&&stack.peek().equals("("))
    				stack.pop();
    			stack.push(String.valueOf(temp));
    		}
    	}
    	
    	return Integer.parseInt(stack.pop());
    }
    
    private int helper(String s,int lo,int hi) {
    	int res=0;
    	return res;
    }
}
