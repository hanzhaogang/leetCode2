import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

 

Constraints:

    1 <= n <= 8
 */
public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	List<String> res=new ArrayList<>();
    	bt(res,"",n,0,0);
    	return res;
    }
    
    private  void bt(List<String> res,String str,int n,int leftCount,int rightCount) {
    	if(str.length()==2*n) {
    		res.add(str);
    		return;
    	}
    	
    	if(leftCount==rightCount) {
    		bt(res,str+"(",n,leftCount+1,rightCount);
    	}else {
    		if(leftCount<n) {
    			bt(res,str+"(",n,leftCount+1,rightCount);
    		}
    		bt(res,str+")",n,leftCount,rightCount+1);
    	}
    }
    // note that I used StringBuilder and failed, then I change to String and succeeded.
}
