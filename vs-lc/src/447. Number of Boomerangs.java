import java.util.HashMap;
import java.util.Map;

public class 447. Number of Boomerangs {
	
}
/* You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. 
A boomerang is a tuple of points (i, j, k) such that 
the distance between i and j equals the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.

 

Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: 2
Example 3:

Input: points = [[1,1]]
Output: 0
 

Constraints:

n == points.length
1 <= n <= 500
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-boomerangs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
	int count=0;
	for(int i=0;i<points.length;i++){
		for(int j=0;j<points.length;j++){
			for(int k=0;k<points.length;k++){
				if(i==j||i==k||j==k){
					continue;
				}else{
					if(
					(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+
					(points[i][1]-points[j][1])*(points[i][1]-points[j][1])==
					(points[i][0]-points[k][0])*(points[i][0]-points[k][0])+
					(points[i][1]-points[k][1])*(points[i][1]-points[k][1]) ){
						count++;
					}

				}
			}
		}
	}
	return count;
    }
}

/* 思路： 在主体循环中，使用两层循环，这样可以确定i、j两点之间的距离d。
此时考虑通过hash表快速查找到除j之外的、距离i也为d的点。

建表：n^2
Map<int[],Map<Integer,Integer>> map=new HashMap<>();

---
提交出错了，是因为用map、直接更新计数值，可能包括重复的情况。
而去重最简单有效的方法是hashset。

---
思路受了三重循环的影响。
考虑哈希的时候，应该重新考虑，跟三重循环没有关系。

hash表，距离->点对count。
重点是不重不漏。
*/
class Solution {
    public int numberOfBoomerangs(int[][] points) {
	    Map<Integer,Integer> dis2count=new HashMap<>();
	    for(int i=0;i<points.length;i++){
		    for(int j=0;j<points.length;j++){
			    if(i==j)
			    	continue;
			    int dis=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+
			    		(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
			    dis2count.put(dis,dis2count.containsKey(dis)?dis2count.get(dis)+1:1);
		    }
	    }

	    int res=0;
	    for(Map.Entry<Integer,Integer> e:dis2count.entrySet()){
		    res+=e.getValue();
	    }
	    return res;
    }
}


class Solution {
    public int numberOfBoomerangs(int[][] points) {
	    Map<Integer,Set<List<Integer>>> dis2pairs=new HashMap<>();
	  for(int i=0;i<points.length;i++){
		    for(int j=0;j<points.length;j++){
			if(i==j)
			    continue;
			int dis=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+
			    		(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
			Set<List<Integer>> pairSet=dis2pairs.containsKey(dis)?dis2pairs.get(dis):
					new HashSet<List<Integer>>();
			pairList.add(Arrays.asList(Math.min(i,j),Math.max(i,j)));
		    }
	    }
	    int res=0;
	    for(Map.Entry<Integer,Set<List<Integer>>> e:dis2pairs.entrySet()){
		Set<List<Integer>> set=e.getValue();    
		List<List<Integer>> list=new ArrayList<>();
		for(List<Integer> l:set){
			list.add(l);
		}
		Set<String> b_set=

	    } 
    }
}