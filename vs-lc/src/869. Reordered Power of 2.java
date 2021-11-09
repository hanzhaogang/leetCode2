import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 869. Reordered Power of 2 {
	
}
/* You are given an integer n. 
We reorder the digits in any order (including the original order) such that 
the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
Example 3:

Input: n = 16
Output: true
Example 4:

Input: n = 24
Output: false
Example 5:

Input: n = 46
Output: true
 

Constraints:

1 <= n <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reordered-power-of-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
1. 暴力
首先求得所有的排列。复杂度为9的阶乘。
针对每一个排列，判断是否为2的幂，复杂度为9。
2. 打表
因为n<=10^9，因此2的幂的个数有限，不超过30个。
表不需要手工写，用一个for循环找到所有不超过10^9的2的幂，把每个数位放入set中。
判断n是否符合要求时，把n转换为由每个数位组成的set，判断set是否相等。
判断set是否相等，可以直接使用Set.equals方法，只要set中的元素可以拿来用作map的key
（正确地实现了equals和hashcode方法）

--set不行，因为可能有重复。map、或者list.
list重写了equals hashCode方法，可以用作map的key*/
class Solution {
    public boolean reorderedPowerOf2(int n) {//1
	Set<List<Integer>> set=new HashSet<>();
	for(int i=0;;i++){
		int p=(int)Math.pow(2,i);
		if((int)Math.pow(10,9)<p){
			break;
		}
		List<Integer> list=new ArrayList<>();
		while(p!=0){
			list.add(p%10);
			p=p/10;
		}
		Collections.sort(list);
		set.add(list);
	}
	List<Integer> list=new ArrayList<>();
	while(n!=0){
		list.add(n%10);
		n/=10;
	}
	Collections.sort(list);
	return set.contains(list);
    }
}