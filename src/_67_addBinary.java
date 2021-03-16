/*
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class _67_ {
    
}

/*
思路：
a b 位数可能不一样。 
一种思路是补齐，空间复杂度高；
另外一种思路是选择a作为基准，倒序遍历，并与b对应位相加。
循环过程中，如果b到达第一位，则继续循环。
循环结束时，如果b并未到达第一位，则继续遍历b。

这道题虽然是道简单题，但是很考察coding的能力！
*/
class Solution {
    public String addBinary(String a, String b) {//0,0
        int jinwei=0;
        StringBuilder sb=new StringBuilder();

        int i=a.length()-1;
        int j=b.length()-1-(a.length()-1-i);
        for(;0<=i;i--,j--){
            char ca=a.charAt(i);
            int bit=0; 
            if(j<0){//b has finished
                bit=(jinwei+ca-'0')%2;
                jinwei=(jinwei+ca-'0')/2;

            }else{
                int res=jinwei+ca-'0'+b.charAt(j)-'0';
                bit=res%2;
                jinwei=res/2;
            }

            sb.insert(0,bit);
        }

        while(0<=j){//这里一般会j--，因为后面可能会忘掉。
            int res=jinwei+b.charAt(j)-'0';
            int bit=res%2;
            jinwei=res/2;
            sb.insert(0,bit);
            j--;
        }

        if(jinwei==1)
            sb.insert(0,jinwei);

        return sb.toString();
    }
}