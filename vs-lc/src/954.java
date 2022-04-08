import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 954 {
	
}
/* Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 

Constraints:

2 <= arr.length <= 3 * 104
arr.length is even.
-105 <= arr[i] <= 105
*/

















































/* 1. int[] 是不能用lambda的自定义comparator的。
需要转换成Integer[] !!!

2. coding时尽量不要临时修改。
如果要临时修改，一定要注意修改处对其他代码产生的影响。
代码注释里的，a[i]赋值为Integer.MAX_VALUE的那一行。。。
*/












class Solution {
    public boolean canReorderDoubled(int[] arr) {
	// TreeSet<Integer> set=new TreeSet<>();
	// for(int i:arr)
	// 	set.add(i);

	Map<Integer,List<Integer>> val2indexs=new HashMap<>();
	Integer[] a=new Integer[arr.length];
	for(int i=0;i<arr.length;i++)
		a[i]=arr[i];
	Arrays.sort(a,(a1,a2)->{
		return Math.abs(a1)-Math.abs(a2);
	});
	for(int i=0;i<a.length;i++){
		List<Integer> list=val2indexs.containsKey(a[i])?val2indexs.get(a[i]):new ArrayList<Integer>();
		list.add(i);
		val2indexs.put(a[i], list);
	}
	for(int i=0;i<a.length;i++){
		if(a[i]==Integer.MAX_VALUE){
			continue;
		}
		if(val2indexs.containsKey(2*a[i])){
			List<Integer> list=val2indexs.get(2*a[i]);
			a[list.get(list.size()-1)]=Integer.MAX_VALUE;
			list.remove(list.size()-1);
			if(list.isEmpty())
				val2indexs.remove(2*a[i]);
			a[i]=Integer.MAX_VALUE;//这一行，一开始是加在循环里的第一行，导致list为空。后来加在前面的if判断的前面。。
		}else{
			return false;
		}
	}
	return true;
    }
}
