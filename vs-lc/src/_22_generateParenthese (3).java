package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

class Solution {
public List<String> generateParenthesis(int n) {
    	List<String> res=new ArrayList<>();
    	helper(res,new StringBuilder(),0,n,n,n);
    	return res;
    }
    private void helper(List<String> res,StringBuilder sb,
    		int lo,int n,int left,int right) {
    	
    	if(lo==2*n) {
    		String str=sb.toString();
    		res.add(str);
    		return;
    	}
    	if(left<0||right<0||right<left)
    		return;
    	
    	helper(res,sb.append("("),lo+1,n,left-1,right);
    	helper(res,sb.append(")"),lo+1,n,left,right-1);
    }
}
public class _22_generateParenthese {
    public List<String> generateParenthesis(int n) {
    	List<String> res=new ArrayList<>();
    	helper(res,new StringBuilder(),0,n,n,n);
    	return res;
    }
    private void helper(List<String> res,StringBuilder sb,
    		int lo,int n,int left,int right) {
    	if(sb.length()==2*n) {
    		String str=sb.toString();
    		res.add(str);
    		return;
    	}
    	
    	if(left<right) {
    		sb.append(")");
        	helper(res,sb,lo+1,n,left,right-1);
        	sb.deleteCharAt(sb.length()-1);
    	} 
    	if(0<left) {
    		sb.append("(");
    		helper(res,sb,lo+1,n,left-1,right);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
}
class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,new StringBuilder(),n,n,n);
        return res;
    }
    
    private void backtrack(List<String> res,StringBuilder sb,
                           int leftCount,int rightCount,int n){
        if(sb.length()==2*n){
            String str=sb.toString();
            if(!res.contains(str))
                res.add(str);
            return;
        }
        
        if(leftCount==rightCount||0<leftCount){
            sb.append("(");
            backtrack(res,sb,leftCount-1,rightCount,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(leftCount!=rightCount&&0<rightCount){
            sb.append(")");
            backtrack(res,sb,leftCount,rightCount-1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }

