package amzn2020june;

import java.util.PriorityQueue;

public class PathWithMaxMinValue2 {

			 /*class Solution:
				    def maximumMinimumPath(self, A: List[List[int]]) -> int:
				        dire = [[1, 0], [-1, 0], [0, 1], [0, -1]]
				        r, c, res = len(A), len(A[0]), 0
				        vi = [[0] * c for _ in range(r)]
				        
				        def dfs(x, y, t):
				            nonlocal res
				            if x == r-1 and y == c-1:
				                res = max(res, t)
				                return 
				            
				            for i, j in dire:
				                nx, ny = i + x, j + y
				                if nx >= 0 and nx < r and ny >= 0 and ny < c and vi[nx][ny] == 0:
				                    vi[nx][ny] = 1
				                    dfs(nx, ny, min(t, A[nx][ny]))
				                    vi[nx][ny] = 0
				        vi[0][0] = 1
				        dfs(0, 0, A[0][0])
				        return res
				*/
	/*
				       * 如果我们想要最后的得分最高，那么我们每一步都尽量走最高的分数（贪心）。由于每次都是去周边得分的最大值，所以不难想到使用排序或者最大堆
				       * （我这里使用了最大堆）
				       * 
				       *   此题的解决思路是贪心，类似于dijkstra的方法。需要一个优先队列来存下能刚访问到的值最大的点作为候选，
				       *   能够访问到的点是已经访问的点的四周的点（初始状态的时候能够访问的点是位于(0, 0)位置的点）。
				       */
				        		
	/*			        		class Solution:
				        		    def maximumMinimumPath(self, A: List[List[int]]) -> int:
				        		        dire = [[1, 0], [-1, 0], [0, 1], [0, -1]]
				        		        r, c, res = len(A), len(A[0]), 0
				        		        vi = [[0] * c for _ in range(r)]
				        		        h = [[-A[0][0], 0, 0]]
				        		        heapq.heapify(h)
				        		        
				        		        def dfs():
				        		            nonlocal res
				        		            pre, x, y = heapq.heappop(h)

				        		            if x == r-1 and y == c-1:
				        		                res = max(res, -pre)
				        		                return 
				        		            
				        		            for i, j in dire:
				        		                nx, ny = i + x, j + y
				        		                if nx >= 0 and nx < r and ny >= 0 and ny < c and vi[nx][ny] == 0:
				        		                    vi[nx][ny] = 1
				        		                    heapq.heappush(h, [max(pre, -A[nx][ny]), nx, ny])
				        		            dfs()
				        		 
				        		        vi[0][0] = 1
				        		        dfs()
				        		        return res
		*/		        		        		
				        		        		/*
				        		        		 * 难道每次选最大的就一定可以有解吗？当然不一定，但是如果最大的情况没有的话，那么我们只要考虑次大的有没有即可，也就是我们要保证每次遍历的情况都是最优的。
				        		        		 */
				        	/*
				        	 * From A[0][0], put element with index into maxHeap, sorted by element. Mark it as visited.

	When polling out the currrent, check its surroundings. If not visited before, put it into maxHeap.

	Until we hit the A[m-1][n-1].

	Time Complexity: O(m*n*logmn). m = A.length. n = A[0].length. maxHeap add and poll takes O(logmn).

	Space: O(m*n).	
				        	
				        	优先级队列

	这个做法的思路应该更常规一点，是我想到的第一个解法，即从起点开始进行搜索，把其周围的所有点都放入大根堆中。遍历时，优先搜索值比较大的点，并把该点周围的所有点放入堆中，直至遇到了终点。

	这个做法非常类似于Prim算法，Prim算法是从一个点开始，每次选择已访问过的所有点周围的没有访问过的点中距离最小的点。这个题反其道而行之，每次选择已访问过的所有点周围的没有访问过的点中值最大的点。

	需要注意的是，会把每个点周围的所有点放入堆中，堆会进行排序，下次选择的仍然是到目前为止可以访问的值最大的点。举例说明：

	[[6, 6, 0],
	 [3, 0, 0],
	 [3, 3, 3]]
	 
	 起始时把[0,1]位置的6和[1,0]位置的3都放入堆中。
	 第一次会选择[0,1]位置的6，
	 但是由于其周围的全是0，0放入堆中排到了后面，
	 所以第二次访问的是[1,0]位置的3
				        	 */
				        		
		int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		
		public int maximumMinimumPath(int[][] A) {
		    int m = A.length;
		    int n = A[0].length;
		    
		    PriorityQueue<int []> maxHeap = 
		        new PriorityQueue<int []>((a, b) -> b[2] - a[2]);
		    maxHeap.add(new int[]{0, 0, A[0][0]});
		    boolean [][] visited = new boolean[m][n];
		    visited[0][0] = true;
		    
		    int res = A[0][0];
		    while(!maxHeap.isEmpty()){
		        int [] cur = maxHeap.poll();
		        res = Math.min(res, cur[2]);
		        if(cur[0]==m-1 && cur[1]==n-1){
		            return res;
		        }
		        
		        for(int [] dir : dirs){
		            int x = cur[0] + dir[0];
		            int y = cur[1] + dir[1];
		            if(x<0 || x>=m ||y<0 || y>=n || visited[x][y]){
		                continue;
		            }
		            
		            visited[x][y] = true;
		            maxHeap.add(new int[]{x, y, A[x][y]});
		        }
		    }
		    
		    return res;
		}
}
