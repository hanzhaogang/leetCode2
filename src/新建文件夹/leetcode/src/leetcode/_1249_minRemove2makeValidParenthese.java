package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

 

Constraints:

    1 <= s.length <= 10^5
    s[i] is one of  '(' , ')' and lowercase English letters.
 
 *
 *  (()())()))
 */
public class _1249_minRemove2makeValidParenthese {
	public static void main(String[] args) {
		_1249_minRemove2makeValidParenthese solution=new _1249_minRemove2makeValidParenthese();
		String s="lee(t(c)o)de)";
		System.out.println(solution.minRemoveToMakeValid_2(s));
	}
	
	public String minRemoveToMakeValid(String s) {
//		Deque<Integer> stack=new ArrayDeque<>();
//		for(int i=0;i<s.length();i++) {
//			char c=s.charAt(i);
//			if(c=='(')
//				stack.push(i);
//			else if(c==')') {
//				if(stack.isEmpty()) {
//					stack.push(i);
//				}else {
//					char top=s.charAt(stack.peek());
//					if(top=='(')
//						stack.pop();
//					else
//						stack.push(i);
//				}
//			}
//		}
//		
//		Set<Integer> set=new HashSet<>(stack);
//		StringBuilder sb=new StringBuilder();
//		for(int i=0;i<s.length();i++) {
//			if(!set.contains(i)) {
//				sb.append(s.charAt(i));
//			}
//		}
//		
//		return sb.toString();
		
		
		
		
		
		
		
		//注意stack的判空操作。
		Deque<Integer> indexStack=new ArrayDeque<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='(') {
				indexStack.push(i);
			}else if(c==')') {
				if(!indexStack.isEmpty() && s.charAt(indexStack.peek())=='(') {
					indexStack.pop();
				}else {
					indexStack.push(i);
				}
			}
		}
		
		Set<Integer> removeIndexSet=new HashSet<>(indexStack);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(!removeIndexSet.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
    }

	public String minRemoveToMakeValid_2(String s) {// lee(t(c)o)de)
		Deque<Integer> removeIndexStack=new ArrayDeque<>();
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i)!='(')&&(s.charAt(i)!=')')) {
				continue;
			}else {
				if(s.charAt(i)=='(') {
					removeIndexStack.push(i);
				}else {
					if(!removeIndexStack.isEmpty()&&s.charAt(removeIndexStack.peek())=='(') {
						removeIndexStack.pop();
					}else {
						removeIndexStack.push(i);
					}
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		Set<Integer> removeIndexSet=new HashSet<>(removeIndexStack);
		
		for(int i=0;i<s.length();i++) {
			if(!removeIndexSet.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
}
