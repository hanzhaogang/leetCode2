import java.util.HashSet;
import java.util.Set;

public class 575. Distribute Candies {
	
}
/* Alice has n candies, where the ith candy is of type candyType[i]. 
Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.

Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

 

Example 1:

Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
Example 2:

Input: candyType = [1,1,2,3]
Output: 2
Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3], she still can only eat 2 different types.
Example 3:

Input: candyType = [6,6,6,6]
Output: 1
Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.
 

Constraints:

n == candyType.length
2 <= n <= 104
n is even.
-105 <= candyType[i] <= 105
通过次数51,886

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distribute-candies
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
candies可能全部相等，也可能每个都不一样。最少1种，最多n/2种。
结果跟candyType的数量t有关：
如果t小于n/2，那么最多只能吃到t种；
反之，最多可以吃到n/2种。
*/
class Solution {
    public int distributeCandies(int[] candyType) {
	Set<Integer> set=new HashSet<>();
	for(int t:candyType){
		set.add(t);
	}
	return set.size()<candyType.length/2?set.size():candyType.length/2;
    }
}