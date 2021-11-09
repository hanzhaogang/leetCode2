import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 10^4
s[i] is '(', or ')'.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class _32_LongestValidParentheses {
    
}
/*思路：
0. 首先要注意审题，注意是substring，不是subsequence。找到所有的subsequence需要2^n指数级时间复杂度，而找到所有的substring只需要n^2
1. BF， 找到所有的substring，针对每个substring判定其是否valid，进而找到最长的valid substring的长度。时间复杂度n^3。
   因为数据规模3*10^4,所以时间复杂度应该在nlogn级别。 
   因为字符串问题难以找到logn级别算法，所以推测应该有线性时间复杂的解法。
   括号对问题一般可以通过stack解决。考虑是否可以通过一遍出栈入栈操作得到解。（？？？）

   ()(()()()
   出栈入栈一次，当遇到栈顶为左括号，当前为右括号的时候，就弹出栈顶元素。最后留在栈里的是无效的，没有入栈的也是无效的。
   记录无效元素的index，计算最长有效substring的长度。

   问题： 1， 无法证明正确性；
          2， 如果使用list存储，invalid的index有可能需要先排序，再计算结果。

          所以还是应该在出栈入栈的时候，每当碰到invalid括号的时候，计算一次长度。

          个人建议不要直接用stack，而是用indexStack，这样在写code的时候不易出错！我第一次写的时候就出错了。
   */
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        boolean[] arr=new boolean[s.length()];

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){//无法判定
                stack.push(i);
            }else{
                if(!stack.isEmpty()&&s.charAt(stack.peek())=='('){//valid 此处s.charAt...=='('易出错！
                    stack.pop();
                }else{//invalid
                    arr[i]=true;
                }
            }
        }

        while(!stack.isEmpty()){
            int index=stack.pop();
            arr[index]=true;
        }
        for(boolean b:arr){
            System.out.println(b);
        }
        int res=0;
        int preInvalid=-1;
        //0010001 "(()" 100
        for(int i=0;i<arr.length;i++){
            if(arr[i]){
                res=Math.max(res,i-preInvalid-1);
                preInvalid=i;
            }
        }
        res=Math.max(res, s.length()-preInvalid-1);
        return res;
    }
}