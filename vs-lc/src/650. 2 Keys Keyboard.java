import java.util.ArrayList;
import java.util.List;

public class 650. 2 Keys Keyboard {
	
}
/* There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

Example 1:

Input: n = 3
Output: 3
Explanation: Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Example 2:

Input: n = 1
Output: 0
 

Constraints:

1 <= n <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/2-keys-keyboard
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
数学，质因式分解。
*/
class Solution {
    public int minSteps(int n) {
	helper(n);
	int res=0;
	for(int i:list){
		res+=i;
	}
	return res;
    }
    List<Integer> list=new ArrayList<>();
    private void helper(int n){
	if(n==1)
		return;
	for(int i=2;i<=n;i++){
		if(n%i==0){
			list.add(i);
			helper(n/i);
			break;
		}
	}
    }
}
