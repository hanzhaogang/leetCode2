package amzn2020june;

import java.util.Deque;
import java.util.LinkedList;

public class _20_validParenthese {
	public boolean isValid(String s) {
		Deque<Character> stack=new LinkedList<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(stack.isEmpty()) {
				if(c==')'||c==']'||c=='}')
					return false;
				else
					stack.push(c);
			}else {
				char top=stack.peek();
				if(top==')'||top==']'||top=='}')
					return false;
				else if(top=='(') {
					if(c==')')
						stack.pop();
						
					else if(c==']'||c=='}')
						return false;
					else 
						stack.push(c);
						
				}else if(top=='[') {
					if(c==']')
						stack.pop();
					else if(c==')'||c=='}')
						return false;
					else
						stack.push(c);
						
				}else if(top=='{') 
					if(c=='}')
						
						stack.pop();
					else if(c==')'||c==']')
						return false;
					else
						stack.push(c);
			}
		}
		
		return stack.isEmpty();
    }
}
