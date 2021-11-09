package leetcode;
/*
 * A string is a valid parentheses string (denoted VPS) 
 * if and only if it consists of "(" and ")" characters only, and:

    It is the empty string, or
    It can be written as AB (A concatenated with B), where A and B are VPS's, or
    It can be written as (A), where A is a VPS.

We can similarly define the nesting depth depth(S) of any VPS S as follows:

    depth("") = 0
    depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
    depth("(" + A + ")") = 1 + depth(A), where A is a VPS.

For example,  "", "()()", and "()(()())" are VPS's 
(with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

 

Given a VPS seq, split it into two disjoint subsequences A and B, 
such that A and B are VPS's (and A.length + B.length = seq.length).

Now choose any such A and B such that 
max(depth(A), depth(B)) is the minimum possible value.

Return an answer array (of length seq.length) 
that encodes such a choice of A and B:  
answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  
Note that even though multiple answers may exist, 
you may return any of them.

 
 "()(((()))(()))"

Example 1:

Input: seq = "(()())"
Output: [0,1,1,1,1,0]

Example 2:

Input: seq = "()(())()"
Output: [0,0,0,1,1,0,1,1]

 

Constraints:

    1 <= seq.size <= 10000
 */
public class _1111_maxNestingDepthOfTwoValidParenttheseString {
	/*
	 * 基本思想是，每一对括号都有自己所在的嵌套层数。在遍历（借助于stack）字符串的同时，标记下层数。然后把括号对所在层数为奇数的分为一组，把所在层数为偶数的分一组。
	 * 
	 */
    public int[] maxDepthAfterSplit(String seq) {
        List<Integer> group1=new ArrayList<>();//index
        Deque<Integer> stack=new ArrayDeque<>();//index
        for(int i=0;i<seq.length();i++){
            char c=seq.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                int j=stack.pop();
                int lv=stack.size();
                if(lv%2==0){
                    group1.add(i);
                    group1.add(j);
                }
            }    
        }

        int[] res=new int[seq.length()];
        for(Integer i:group1){
            res[i]=1;
        }        
        return res;
    }
}
