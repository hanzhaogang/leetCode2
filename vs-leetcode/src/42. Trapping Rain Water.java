import java.util.ArrayDeque;
import java.util.Deque;

public class 42. Trapping Rain Water {
	
}
/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
n^2的算法也能通过。。。

首先，确定每一列的计算方式：每一列的雨水量=Math.min(该列左侧最高,该列右侧最高）-列高
接下来，不用什么单调栈、双指针啥的复杂操作，直接倒序遍历一遍数组，就可以求得每一列右侧的最高高度。
*/
class Solution {
    public int trap(int[] height) {
	    int n=height.length;
	int[] l=new int[n];//_next_larger_indexs_left2right
	Deque<Integer> s=new ArrayDeque<>();
	for(int i=0;i<n;i++){
		if(s.isEmpty()||height[i]<=s.peek()){
			s.push(i);
		}
		while(!s.isEmpty()&&s.peek()<height[i]){
			int poped=s.pop();
			l[poped]=i;
		}
	}
	s.clear();
	int[] r=new int[n];//_next_larger_indexs_right2left

    }

    public int trap(int[] height) {
	    int n=height.length;
	    int[] r=new int[n];
	    int r_max=0;
	    for(int i=n-1;0<=i;i--){
		r[i]=r_max;
		r_max=Math.max(height[i],r_max);
	    }   
	    int[] l=new int[n];
	    int l_max=0;
	    for(int i=0;i<n;i++){
		    l[i]=l_max;
		    l_max=Math.max(height[i],l_max);
	    }
	    int res=0;
	    for(int i=1;i<n-1;i++){
		res+=height[i]<Math.min(l[i],r[i])?(Math.min(l[i],r[i])-height[i]):0;
	    }
	    return res;
    }
}
