package leetcode;
/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

  b a b a d
b t f t   
a   t f t
b     t f f
a       t f
d         t



"babadcbbcda"

 b a b a d c b b c d a
b1 0 1 0         ?
a  1 0 1 0
b    1 0 0
a      1 0 0 0         ?
d        1 0 0 0 0 ?
c          1 0 0 1 0
b            1 1 0
b              1 0 0
c                1 0 0
d                  1 0
a                    1

 */
public class _5_longestPalindromicSubstring {
	public static void main(String[] args) {
		_5_longestPalindromicSubstring s=new _5_longestPalindromicSubstring();
//		String S="banana";
//		String S="babadcbbcda";
		String S="cbbd";
		System.out.println(s.longestPalindrome(S));
	}
	public String longestPalindrome(String s) {
		if(s.length()==0)
			return "";
		
    	String res=s.substring(0,1);

    	int len=s.length();
    	boolean[][] dp=new boolean[len][len];
    	for(int i=0;i<len;i++) {
    		dp[i][i]=true;
    		if(i+1<len){
    			if(s.charAt(i)==s.charAt(i+1)) {
    				dp[i][i+1]=true;
    				String sub=s.substring(i, i+2);
    				res=res.length()<sub.length()?sub:res;
    			}
    		}
    	}
    	
    	for(int m=2;m<len;m++) {
    		for(int n=0;n+m<len;n++) {
    			int i=n;
    			int j=m+n;
    			if(!dp[i+1][j-1])
    				dp[i][j]=false;
    			else if(s.charAt(i)==s.charAt(j)){
    				dp[i][j]=true;
    				String sub=s.substring(i, j+1);
    				res=res.length()<sub.length()?sub:res;
    			}
    				
    		}
    	}
    	return res;
    }
}
