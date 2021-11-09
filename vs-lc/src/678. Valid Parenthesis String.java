public class 678. Valid Parenthesis String {
	
}
/* Given a string s containing only three types of characters: '(', ')' and '*', 
return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' 
or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parenthesis-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
二维DP数组上，再加一层for循环。

有效string有两种类型： 
两个有效string拼接；
*/
class Solution {
    public boolean checkValidString(String s) {
	boolean[][] dp=new boolean[s.length()][s.length()];
	for(int i=s.length();0<=i;i--){
		for(int j=i;j<s.length();j++){
			if(i==j){
				dp[i][j]=s.charAt(i)=='*'?true:false;
			} else{
				boolean cur=false;
				if( 
					( (s.charAt(i)=='(')&&(s.charAt(j)==')')||
						(s.charAt(i)=='(')&&(s.charAt(j)=='*')||
						(s.charAt(i)=='*')&&(s.charAt(j)=='*')||
						(s.charAt(i)=='*'&&s.charAt(j)==')')  ) &&

						(    i==j-1 || (i<j-1) && dp[i+1][j-1]     )    
				){
					cur=true;
				}else{
					for(int k=i;k<j;k++){
					if(dp[i][k]&&dp[k+1][j]){
						cur=true;
						break;
					}
				}
				}
				
				dp[i][j]=cur;
			}
		}
	}
	return dp[0][s.length()-1];
    }
}
