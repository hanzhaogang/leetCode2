package leetCode;
/*
 * Given an input string (s) and a pattern (p), 
 * implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

  '' a a
'' t f f
 a f t f

Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

  '' a a
'' t f f
 * t t t


Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

  '' c b
'' t f f
?  f t f 
a  f f f

 
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, 
while the second '*' matches the substring "dce".

  '' a d c e b
'' t f f f f f 
 * t t t t t t
 a f t f f f f
 * f t t t t t
 b f f f f f t
 
 
 
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false

  '' a c d c b
'' t f f f f f
 a f t f f f f 
 * f 
 c f
 ? f
 b f


 */
public class _44_wildcardMatching {
    public boolean isMatch(String s, String p) {
    	/*
    	 *     '' a d c e b
    	 *   '' t f f f f f
    	 *    * t t t t t t
    	 *    a f t f f f f  
    	 *    * f t t t t t 
    	 *    b f f f f f  
    	 *     
    	 */
    	if(s==null||p==null)
    		return false;
    	if(s.length()==0&&p.length()==0) {
    		return true;
    	}
    	if(s.length()==0) {
    		if(p.length()==1&&p.charAt(0)=='*') {
    			return true;
    		}else
    			return false;
    	}
    	if(p.length()==0) {
    		return false;
    	}
    	
    	
    	boolean[][] dp=new boolean[p.length()+1][s.length()+1];
    	dp[0][0]=true;
    	for(int j=1;j<=s.length();j++) {
    		dp[0][j]=false;
    	}
    	boolean leadingStar=false;
    	for(int i=1;i<=p.length();i++) {
    		if(p.charAt(i-1)=='*') {
    			if(i==1) { 
    				dp[i][0]=true;
    				leadingStar=true;
    			}else {
    				if(leadingStar)
    					dp[i][0]=true;
    				else
    					dp[i][0]=false;
    			}
    		}else {
    			dp[i][0]=false;
    			leadingStar=false;
    		}
    	}
    	
    	for(int i=1;i<=p.length();i++) {
    		for(int j=1;j<=s.length();j++) {
    			if(s.charAt(j-1)==p.charAt(i-1)||p.charAt(i-1)=='?') {
    	    		dp[i][j]=dp[i-1][j-1];
    	    	}else if(p.charAt(i-1)=='*') {// *
    	    		dp[i][j]=dp[i-1][j]||dp[i][j-1];
    	    	}else {
    	    		dp[i][j]=false;
    	    	}
    		}
    	}
    	
    	
    	return dp[p.length()][s.length()];		
    }
}
