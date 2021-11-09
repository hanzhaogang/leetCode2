public class 639. Decode Ways II {
	
}
/* A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, 
all the digits must be grouped then mapped back into letters 
using the reverse of the mapping above (there may be multiple ways). 
For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' 
since "6" is different from "06".

In addition to the mapping above, an encoded message may contain the '*' character, 
which can represent any digit from '1' to '9' ('0' is excluded). 
For example, the encoded message "1*" may represent any of the encoded messages 
"11", "12", "13", "14", "15", "16", "17", "18", or "19". 
Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

Given a string s consisting of digits and '*' characters, 
return the number of ways to decode it.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: s = "*"
Output: 9
Explanation: The encoded message can represent any of the encoded messages 
"1", "2", "3", "4", "5", "6", "7", "8", or "9".
Each of these can be decoded to the strings 
"A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
Hence, there are a total of 9 ways to decode "*".
Example 2:

Input: s = "1*"
Output: 18
Explanation: The encoded message can represent any of the encoded messages 
"11", "12", "13", "14", "15", "16", "17", "18", or "19".
Each of these encoded messages have 2 ways to be decoded 
(e.g. "11" can be decoded to "AA" or "K").
Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
Example 3:

Input: s = "2*"
Output: 15
Explanation: The encoded message can represent any of the encoded messages 
"21", "22", "23", "24", "25", "26", "27", "28", or "29".
"21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, 
but "27", "28", and "29" only have 1 way.
Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".
 

Constraints:

1 <= s.length <= 105
s[i] is a digit or '*'.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
根据数据规模可知，复杂度为n或者nlgn才可以通过OJ。
但是堆、二分查找找不到可以应用的迹象，所以应该是线性时间复杂度的DP。
因此dp数组应该是一维的、并且在求解当前dp[i]的时候，不需要遍历之前的dp值，
只需要根据常量个数的前值就可以。

leading zero?

打表思想的使用。*/
class Solution {
    public int numDecodings(String s) {
	int n=s.length();
	long[] dp=new long[n];
	long mod=(long)Math.pow(10,9)+7;
	for(int i=0;i<n;i++){
		char c=s.charAt(i);
		if(i==0){
			if(c=='*'){
				dp[i]=9;
			}else if('1'<=c&&c<='9'){
				dp[i]=1;
			}	
		}else{	
			char pre=s.charAt(i-1);
			if(c=='*'){
				dp[i]+=9*dp[i-1];
				if(pre=='*'){
					if(0<=i-2)
						dp[i]+=15*dp[i-2];
					else
						dp[i]+=15;
				}else if(pre=='1'){
					if(0<=i-2){
						dp[i]+=9*dp[i-2];
					}else{
						dp[i]+=9;
					}
				}else if(pre=='2'){
					if(0<=i-2){
						dp[i]+=6*dp[i-2];
					}else{
						dp[i]+=6;
					}	
				}	
			}else if(c=='0'){
				if(pre=='1'||pre=='2'){
					if(0<=i-2){
						dp[i]+=dp[i-2];
					}else{
						dp[i]=1;
					}
				}else if(pre=='*'){
					if(0<=i-2){
						dp[i]+=2*dp[i-2];
					}else{
						dp[i]=2;
					}
				}
			}else if('1'<=c&&c<='9'){
				dp[i]+=dp[i-1];
				if(pre=='*'){//*1
					if('1'<=c&&c<='6'){
						if(0<=i-2){
							dp[i]+=2*dp[i-2];
						}else{
							dp[i]+=2;
						}
					}else{
						if(0<=i-2){
							dp[i]+=dp[i-2];
						}else{
							dp[i]+=1;
						}
					}
						
				} else if(pre=='1'||pre=='2'&&'1'<=c&&c<='6'){
					if(0<=i-2){
						dp[i]+=dp[i-2];
					}else{
						dp[i]++;
					}	
				}
			}
		}
		dp[i]=dp[i]%mod;
	}

	return (int)(dp[n-1]%mod);
    }
}