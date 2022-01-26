import java.util.PriorityQueue;

public class mst_17.14. 最小K个数 {
	
}
/* 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-k-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
数据规模10^5,nlgn可以过。
维护一个大小为k的最大堆。
复杂度为nlgk
*/
class Solution {
    public int[] smallestK(int[] arr, int k) {
	int[] res=new int[k];
	PriorityQueue<Integer> heap=new PriorityQueue<>((i1,i2)->{
		return Integer.compare(i2, i1);
	});
	for(int i:arr){
		if(heap.isEmpty()||heap.size()<k){
			heap.offer(i);
		}else{
			int peek=heap.peek();
			if(peek<=i){
				continue;
			}else{
				heap.poll();
				heap.offer(i);
			}
		}
		
	}
	if(k==0)
		return res;
	int p=0;
	while(!heap.isEmpty()){
		res[p++]=heap.poll();
	}
	return res;
    }
}
