package leetCode;
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
尽可能地均匀平分

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
	 * 1. get the depth of seq.
	 * 
	 */
    public int[] maxDepthAfterSplit(String seq) {
        
    }
}


class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
        
        //find count
        int c=0;
        for(int i=0;i<seq.length();i++)
            if(seq.charAt(i)=='(') c++;
        
        int c0=c/2;
        /*
        (()()((())()))
        */
        Deque<int[]> s=new ArrayDeque<>();
        c=0;
        List<Integer> indexL= new ArrayList<>();
        for(int i=0;i<seq.length();i++){
            if(c==c0) break;
            
            int m=seq.charAt(i)=='('?0:1;//this line was in if clause.
            
            if(s.isEmpty()){
                
                s.push(new int[]{m,i});    
            }else{
                int[] top=s.peek();
                if(top[0]==0&&seq.charAt(i)==')'||
                        top[0]==1&&seq.charAt(i)=='('){
                    s.pop();
                    indexL.add(top[1]);
                    indexL.add(i);
                    c++;
                }else{
                    s.push(new int[]{m,i});
                }    
            }  
        }
        
        int[] res=new int[seq.length()];
        for(int i=0;i<indexL.size();i++)
            res[indexL.get(i)]=1;
        return res;
    }
}