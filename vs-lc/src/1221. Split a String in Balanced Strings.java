public class 1221. Split a String in Balanced Strings {
	
}
/* Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it in the maximum amount of balanced strings.

Return the maximum amount of split balanced strings.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", 
since each substring contains an equal number of 'L' and 'R'
 

Constraints:

1 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
贪心。时间复杂度O(n)。
*/
class Solution {
    public int balancedStringSplit(String s) {
	int lc=0;
	int rc=0;
	int res=0;
	for(int i=0;i<s.length();i++){
		char c=	s.charAt(i);
		if( c=='L'&&(lc+1==rc)|| c=='R'&&(rc+1==lc) ){
			res++;
			lc=0;
			rc=0;
		}else{
			if(c=='L')
				lc++;
			else
				rc++;	
		}
	}
	return res;
    }
}