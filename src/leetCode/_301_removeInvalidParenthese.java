package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Remove the minimum number of invalid parentheses in order to make the input string valid. 
 * Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:

Input: ")("
Output: [""]

(a)b)c)d)
(a)bcd
(ab)cd
(abc)d
(abcd)

()((()

()))((()
 */
public class _301_removeInvalidParenthese {
	public static void main(String[] args) {
		_301_removeInvalidParenthese s=new _301_removeInvalidParenthese();
//		String str="()())()";//["(())()"]
//		String str="(a)())()";
//		String str="())(";
		String str="(j))(";
		System.out.println(s.removeInvalidParentheses(str));
	}
    public List<String> removeInvalidParentheses(String s) {
    	int[] counts=getCounts(s);
    	
    	Set<String> combs=new HashSet<>();
    	bt(combs,new StringBuilder(),s,counts,0);
    	
    	List<String> res=new ArrayList<>();
    	for(String comb:combs) {
    		if(isValid(comb))
    			res.add(comb);
    	}
    	
    	return res;
    }
    
    private void bt(Set<String> combs,StringBuilder sb,String s,int[] leftCounts,int lo){//())(
    	if((0<leftCounts[0]||0<leftCounts[1])&&s.length()<=lo) {
//    		sb.delete(0,sb.length());
    		return;
    	}
    	
    	if(leftCounts[0]==0&&leftCounts[1]==0) {
    		int l=s.substring(lo).length();
    		sb.append(s.substring(lo));
    		String comb=sb.toString();
    		combs.add(comb);
    		sb.delete(sb.length()-l, sb.length());
    		return;
    	}
    	
    	char curChar=s.charAt(lo);
    	if(curChar!='('&&curChar!=')') {
    		bt(combs,sb.append(curChar),s,leftCounts,lo+1);
    		sb.deleteCharAt(sb.length()-1);
    	}else if(curChar=='(') {
    		if(0<leftCounts[0]) {
    			leftCounts[0]--;
    			bt(combs,sb,s,leftCounts,lo+1);
    			leftCounts[0]++;
    			bt(combs,sb.append(curChar),s,leftCounts,lo+1);
    			sb.deleteCharAt(sb.length()-1);
    		}else {
    			bt(combs,sb.append(curChar),s,leftCounts,lo+1);
    			sb.deleteCharAt(sb.length()-1);
    		}
    	}else {
    		if(0<leftCounts[1]) {
    			leftCounts[1]--;
    			bt(combs,sb,s,leftCounts,lo+1);
    			leftCounts[1]++;
    			bt(combs,sb.append(curChar),s,leftCounts,lo+1);
    			sb.deleteCharAt(sb.length()-1);
    		}else {
    			bt(combs,sb.append(curChar),s,leftCounts,lo+1);
    			sb.deleteCharAt(sb.length()-1);
    		}
    	}
    }
    
    private boolean isValid(String s) {
    	Deque<Character> stack=new ArrayDeque<>();
    	for(char c:s.toCharArray()) {
    		if(c!='('&&c!=')') {
    			continue;
    		}
    		if(!stack.isEmpty()&&stack.peek()=='('&&c==')') {
    			stack.pop();
    		}else {
    			stack.push(c);
    		}
    	}
    	
    	return stack.isEmpty();
    }
	private int[] getCounts(String s) {
		Deque<Character> stack=new ArrayDeque<>();
    	for(char c:s.toCharArray()) {
    		if(c!='('&&c!=')')
    			continue;
    		if(stack.isEmpty()||stack.peek()==c||stack.peek()==')'&&c=='(') {
    			stack.push(c);
    		}else {
    			stack.pop();
    		}
    	}
    	int leftCount=0;
    	int rightCount=0;
    	while(!stack.isEmpty()) {
    		char c=stack.pop();
    		if(c=='(')
    			leftCount++;
    		else
    			rightCount++;
    	}
    	
    	return new int[] {leftCount,rightCount};
	}
}



//class Solution {
//
//	  private Set<String> validExpressions = new HashSet<String>();
//	  private int minimumRemoved;
//
//	  private void reset() {
//	    this.validExpressions.clear();
//	    this.minimumRemoved = Integer.MAX_VALUE;
//	  }
//
//	  private void recurse(
//	      String s,
//	      int index,
//	      int leftCount,
//	      int rightCount,
//	      StringBuilder expression,
//	      int removedCount) {
//
//	    // If we have reached the end of string.
//	    if (index == s.length()) {
//
//	      // If the current expression is valid.
//	      if (leftCount == rightCount) {
//
//	        // If the current count of removed parentheses is <= the current minimum count
//	        if (removedCount <= this.minimumRemoved) {
//
//	          // Convert StringBuilder to a String. This is an expensive operation.
//	          // So we only perform this when needed.
//	          String possibleAnswer = expression.toString();
//
//	          // If the current count beats the overall minimum we have till now
//	          if (removedCount < this.minimumRemoved) {
//	            this.validExpressions.clear();
//	            this.minimumRemoved = removedCount;
//	          }
//	          this.validExpressions.add(possibleAnswer);
//	        }
//	      }
//	    } else {
//
//	      char currentCharacter = s.charAt(index);
//	      int length = expression.length();
//
//	      // If the current character is neither an opening bracket nor a closing one,
//	      // simply recurse further by adding it to the expression StringBuilder
//	      if (currentCharacter != '(' && currentCharacter != ')') {
//	        expression.append(currentCharacter);
//	        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
//	        expression.deleteCharAt(length);
//	      } else {
//
//	        // Recursion where we delete the current character and move forward
//	        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
//	        expression.append(currentCharacter);
//
//	        // If it's an opening parenthesis, consider it and recurse
//	        if (currentCharacter == '(') {
//	          this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
//	        } else if (rightCount < leftCount) {
//	          // For a closing parenthesis, only recurse if right < left
//	          this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
//	        }
//
//	        // Undoing the append operation for other recursions.
//	        expression.deleteCharAt(length);
//	      }
//	    }
//	  }
//
//	  public List<String> removeInvalidParentheses(String s) {
//
//	    this.reset();
//	    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
//	    return new ArrayList(this.validExpressions);
//	  }
//	}
//
