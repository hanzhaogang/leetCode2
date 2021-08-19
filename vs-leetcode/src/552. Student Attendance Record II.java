public class 552. Student Attendance Record II {
	
}
/* An attendance record for a student can be represented as a string 
where each character signifies whether the student was absent, late, or present on that day. 
The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, 
return the number of possible attendance records of length n that 
make a student eligible for an attendance award. 
The answer may be very large, so return it modulo 109 + 7.

 

Example 1:

Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
Example 2:

Input: n = 1
Output: 3
Example 3:

Input: n = 10101
Output: 183236316
 

Constraints:

1 <= n <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/student-attendance-record-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路： 
根据复杂度，判断是一个O（n）或者O（nlgn）的问题。

直觉这道题跟dp有关：
长度为n的满足要求的string个数，跟之前的长度为n-1，n-2.。的字符串个数有关。
更具体地，f(n)=f(n,以a结尾)+f(n,以l结尾)+f(n,以p)结尾。
其中，
f(n,以p结尾)=f(n-1), 因为以p结尾的话，完全不会把f(n-1）的string个数减少。
f(n,以a结尾)=f(n-1)-1*f(n-1,以a结尾)-2*f(n-2,以a结尾)-。。。-f(1,以a结尾)
f（n,以l结尾）=f(n-1)-f(n-1,以ll结尾)=f(n-1)-【f(n-3,以a结尾）+f（n-3,以p结尾）】，
因为会把f（n-1）的string个数，减去长度为n-1、形式为：。。。ll的字符串个数

接下来考虑如何建表、填表：
         
           1  2  3  4                              n（字符串长度 ）
         A 1  2  5
         L 1  3
         P 1  3 
（结尾字符）

时间复杂度：
因为f（n，以a结尾)的计算需要遍历从f(0,a),f(1,a),....的长度为n的dp表格，
所以时间复杂度为n^2.

*/
class Solution {
    public int checkRecord(int n) {

    }
}

class Solution {
    public int checkRecord(int n) {
      long[][][] dp=new long[n+1][2][3];
      dp[1][0][0]=1;
      dp[1][0][1]=1;
      dp[1][0][2]=0;
      dp[1][1][0]=1;
      dp[1][1][1]=0;
      dp[1][1][2]=0;
      for(int i=2;i<=n;i++){
        for(int j=0;j<2;j++){
          for(int k=0;k<3;k++){
            dp[i][0][0]=dp[i-1][0][0]%(long)(Math.pow(10,9)+7)+dp[i-1][0][1]%(long)(Math.pow(10,9)+7)
            +dp[i-1][0][2]%(long)(Math.pow(10,9)+7);
            dp[i][0][1]=dp[i-1][0][0];
            dp[i][0][2]=dp[i-1][0][1];
            dp[i][1][0]=dp[i-1][0][0]%(long)(Math.pow(10,9)+7)+dp[i-1][0][1]%(long)(Math.pow(10,9)+7)
            +dp[i-1][0][2]%(long)(Math.pow(10,9)+7)+
                        dp[i-1][1][0]%(long)(Math.pow(10,9)+7)+dp[i-1][1][1]%(long)(Math.pow(10,9)+7)
                        +dp[i-1][1][2]%(long)(Math.pow(10,9)+7);
            dp[i][1][1]=dp[i-1][1][0];
            dp[i][1][2]=dp[i-1][1][1];
          }
        }
      }

      long res=0;
      for(int j=0;j<2;j++){
        for(int k=0;k<3;k++){
          res+=dp[n][j][k]%(Math.pow(10,9)+7);
        }
      }
      return (int)(res%(Math.pow(10,9)+7));
    }
}


/* 后记：
有两点做的不好： 
1. 考虑可能的状态转换的时候，考虑的不全面。
2. %（10^9+7）做的不好，老是出数据类型转换的语法错误。
*/