package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1167_MinCostConnectSticks_1872 {
	/*You have some sticks with positive integer lengths.

	You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  
	You perform this action until there is one stick remaining.

	Return the minimum cost of connecting all the given sticks into one stick in this way.

	 

	Example 1:

	Input: sticks = [2,4,3]
	Output: 14

	Example 2:

	Input: sticks = [1,8,3,5]
	Output: 30

	 

	Constraints:

	    1 <= sticks.length <= 10^4
	    1 <= sticks[i] <= 10^4
*/	
	
	public static void main(String[] args) {
		_1167_MinCostConnectSticks_1872 m=new _1167_MinCostConnectSticks_1872();
		List<Integer> sticks=Arrays.asList(3,4,5,8);
		System.out.println(m.MinimumCost(sticks));
	}
	public int MinimumCost(List<Integer> sticks) {
		/*[2,3,4]
		 * [1,3,5,8] 4,9,17=30
		 * [3,4,5,8] 7 12 20
		 */
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i:sticks) {
			pq.offer(i);
		}
		
		int res=0;//3
		while(1<pq.size()) {
			//System.out.println(pq);
			int sum=0;
			sum+=pq.poll();//7,12
			if(pq.size()!=0)
				sum+=pq.poll();
			pq.offer(sum);//5 7 8;7 8 12
			res+=sum;
		}
		
		return res;
	}
}
