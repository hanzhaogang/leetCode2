import java.util.ArrayList;
import java.util.List;

public class 352. Data Stream as Disjoint Intervals {
	
}
class SummaryRanges {
	List<int[]> list;
    public SummaryRanges() {
	list=new ArrayList<int[]>();
    }
    
    public void addNum(int val) {//1,3,7,2,6
	if(list.isEmpty()){
		list.add(new int[]{val,val});
	}else {
		int lo=0,hi=list.size()-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			int[] midIntvl=list.get(mid);
			int[] preIntvl=(0<=mid-1)?list.get(mid-1):null;
			int[] sucIntvl=(mid+1<list.size())?list.get(mid+1):null;
			if(midIntvl[0]<=val&&val<=midIntvl[1]){
				return;
			}else if((val==midIntvl[0]-1)){
				if(preIntvl==null||preIntvl!=null&&(preIntvl[1]+1<val)){
					list.remove(mid);
					list.add(mid, new int[]{val,midIntvl[1]});
				}else{
					list.remove(mid-1);
					list.remove(mid-1);
					list.add(mid-1,new int[]{preIntvl[0],midIntvl[1]});
				}
				return;
			}else if(val==midIntvl[1]+1){
				if(sucIntvl==null||sucIntvl!=null&&(val<sucIntvl[0]-1)){
					list.remove(mid);
					list.add(mid, new int[]{midIntvl[0],val});
				}else{
					list.remove(mid);
					list.remove(mid);
					list.add(mid,new int[]{midIntvl[0],sucIntvl[1]});
				}	
				return;
			}else{
				if(val<midIntvl[0]){
					hi=mid-1;
				}else if(midIntvl[1]<val){
					lo=mid+1;
				}
			}
		}
		if(lo<=list.size()-1){
			list.add(lo,new int[]{val,val});
		}else{
			list.add(new int[]{val,val});
		}
	}
    }
    
    public int[][] getIntervals() {
	int[][] res=new int[list.size()][2];
	for(int i=0;i<list.size();i++){
		res[i]=list.get(i);
	}
	return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
/* Given a data stream input of non-negative integers a1, a2, ..., an, 
summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int val) Adds the integer val to the stream.
int[][] getIntervals() Returns 
a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi].
 

Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 

Constraints:

0 <= val <= 104
At most 3 * 104 calls will be made to addNum and getIntervals.
 

Follow up: 
What if there are lots of merges and 
the number of disjoint intervals is small compared to the size of the data stream?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
一开始，想到了区间树。还想到了用二叉树记录nums，用其他数据结构记录区间。。
其实，nums跟区间，不需要同时记录。只记录不相交的区间就行了。
---总结：
不要看题目后，想着把某些套路套到题目上。
还是要从题目本身出发，根据题目思考解决方案。

维护一个不相交的区间集合。每次addNum，更新这个集合。每次getIntervals，返回这个集合。

---
这些不相交的区间是严格有序的。
维护一个有序的不相交区间的列表，每次getIntervals时返回该列表即可。
该列表的初始状态是只有一个区间。每次addNum，通过二分查找寻找num相邻或所落在的区间。
找到相邻区间就把num合并进区间（有可能与两个区间相邻）。
发现num落在已有区间中就忽略。
找不到相邻区间就单独为num创建一个区间。

二分查找必须基于支持随机访问的数据结构，比如数组或者ArrayList，而不能是LinkedList。
数组的合并效率比较低，每次合并都需要O(n)的复杂度。所以可以考虑用树形结构代替数组。
平衡二叉树（如果不平衡、极端情况下退化为数组。）、二叉查找树、AVL数、红黑树、B树、
*/