package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:

You can assume that you can always reach the last index.
先来看看BFS的解法
        > 其实每到达一个点i，都会有nums[i]种跳跃选择，可以把每一轮的跳跃都加入队列中，然后再依次出队列，是可以得到最快到达终点的解的
        > 其实是可以用优先队列的，不过我们自己保障了普通队列的顺序也行，按照跳跃距离从大到小入队列，对最终到达target是有帮助的
        > 数据结构：队列内存储pair<int, int>, 标识当前位置和跳跃步数，设置visited数组来防止重复遍历
 */
public class _45_jumpingGame2 {
    public int jump(int[] nums) {
    	PriorityQueue<Pair> q=new PriorityQueue<>((p1,p2)-> {
    		if(p1.lv!=p2.lv)
    			return p1.lv-p2.lv;
    		else
    			return p2.index-p1.index;
    	});
    	q.offer(new Pair(0,0));
    	
    	Set<Integer> visited=new HashSet<>();
    	visited.add(0);
    	// 2 3 1 1 4
    	int count=0;
    	while(!q.isEmpty()) {
    		int size=q.size();
    		for(int i=0;i<size;i++) {
    			int curIndex=q.poll().index;
    			if(curIndex==nums.length-1)
    				return count;
    			int curStep=nums[curIndex];
    			for(int j=1;j<=curStep;j++) {
    				int nextIndex=curIndex+j;
    				if(nextIndex==nums.length-1) {
    					return count+1;
    				}
    				if(!visited.contains(nextIndex)) {
    					q.offer(new Pair(nextIndex,count));
    					visited.add(nextIndex);
    				}
    			}
    		}
    		
    		count++;
    	}
    	
    	return count;
    }
}

class Pair{
	Integer index;
	Integer lv;
	
	public Pair(Integer index,Integer lv) {
		this.index=index;
		this.lv=lv;
	}
}
