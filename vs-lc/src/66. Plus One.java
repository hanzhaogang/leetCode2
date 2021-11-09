import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 66. Plus One {
	
}
/* You are given a large integer represented as an integer array digits, 
where each digits[i] is the ith digit of the integer. 
The digits are ordered from most significant to least significant in left-to-right order. 
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [0]
Output: [1]
Explanation: The array represents the integer 0.
Incrementing by one gives 0 + 1 = 1.
Thus, the result should be [1].
Example 4:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
一遍遍历。
如果digits全部为9，那么返回1.。0。
否则位数跟原数组一样，可以原地遍历。
从n-1位到0位遍历，维护一个进位，如果当前int+addition<10,addition置为0；如果==10，置为1。

为了代码简洁，也可以先分配一个ArrayList，一遍遍历得到结果，然后把ArrayList转换为int[].*/
class Solution {
    public int[] plusOne(int[] digits) {
	List<Integer> list=new ArrayList<>();
	int a=1;
	for(int i=digits.length-1;0<=i;i--){
		int sum=a+digits[i];
		if(sum==10){
			list.add(0);
			a=1;
		}else{
			list.add(sum);
			a=0;
		}
	}
	if(a==1){
		list.add(a);
	}
	Collections.reverse(list);
	
	int[] res=new int[list.size()];
	for(int i=0;i<res.length;i++){
		res[i]=list.get(i);
	}
	return res;
    }
}
