import java.util.HashSet;
import java.util.Set;

public class 526. Beautiful Arrangement {
	
}
/* Suppose you have n integers labeled 1 through n. 
A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement 
if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

 

Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 15

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/beautiful-arrangement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
看数据规模、看题意中的排列关键词，可以判断这是一个回溯（递归问题。）
在回溯的过程中判断满不满足要求，如果不满足要求，及时剪枝。


*/
class Solution {
    Set<Integer> placedSet;
    int n;//1;
    public int countArrangement(int n) {//2
	placedSet=new HashSet<Integer>();
	this.n=n;
	return helper(1,placedSet);
    }
    private int helper(int lo,Set<Integer> placedSet){//1
	if(lo==n+1){//1==1+1?
		return 1;
	}
	int count=0;
	for(int i=1;i<=n;i++){//1
		if(!placedSet.contains(i) &&( (i)%(lo)==0 || (lo)%(i)==0 )){
			placedSet.add(i);
			count+=helper(lo+1,placedSet);
			placedSet.remove(i);
		}
	
	}
	return count;
    }
}
