import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
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
public class _227_basicCalculator2 {//3/2
	public static void main(String[] args) {
		_227_basicCalculator2 solution=new _227_basicCalculator2();
		String s="3/2";
		solution.calculate(s);
	}
    public int calculate(String s) {
    	if(s==null||s.length()==0)
			return 0;
			
    	//step 1 split
    	List<String> list=new ArrayList<>();
    	StringBuilder sb=new StringBuilder();
    	int p=0;
    	while(p<s.length()) {
    		char c=s.charAt(p);
    		if(c=='+'||c=='-'||c=='*'||c=='/') {
    			list.add(sb.toString());
    			list.add(String.valueOf(c));
    			sb.setLength(0);
    		}else if(c!=' '){
    			sb.append(c);
    		}
    		p++;//ensure this line will always be executed !
    	}
    	list.add(sb.toString());
    	
    	//step 2 calculate * /
    	Deque<String> stack=new ArrayDeque<>();// 3 / 2
    	for(int i=0;i<list.size();i++) {
    		String str=list.get(i);
    		char c_1=str.charAt(0);
    		if(c_1!='*'&&c_1!='/') {
    			stack.push(str);
    		}else{
    			String str1=stack.pop();
    			i++;
    			String str2=list.get(i);
   				int cur_res=(c_1=='*')?Integer.parseInt(str1)*Integer.parseInt(str2):
   						Integer.parseInt(str1)/Integer.parseInt(str2);
   				stack.push(String.valueOf(cur_res));
    		}
    	}
    	
    	//step 3
    	int res=0;
    	while(!stack.isEmpty()) {
    		if(stack.size()==1) {
    			res+=Integer.parseInt(stack.pop());
    		}else {
    			String val=stack.pop();
    			String mark=stack.pop();
    			res+=mark.equals("+")?Integer.parseInt(val):0-Integer.parseInt(val);
    		}
    	}
    	return res;
    }
}
