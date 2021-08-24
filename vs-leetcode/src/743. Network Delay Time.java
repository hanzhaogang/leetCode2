import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 743. Network Delay Time {
	
}
/* You are given a network of n nodes, labeled from 1 to n. 
You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where 
ui is the source node, 
vi is the target node, 
and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. 
Return the time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100（节点数）
1 <= times.length <= 6000（边数）
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
----排除了一个重要的corner case。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/network-delay-time
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

hint
We visit each node at some time, 
and if that time is better than the fastest time we've reached this node, 
we travel along outgoing edges in sorted order. 

Alternatively, we could use Dijkstra's algorithm.

同时要准备一个visited标记，比如把每个访问过的元素放入visited set中

*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
	    // 建图 - 邻接表
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
        for (int[] edg : times) {
            if (!mp.containsKey(edg[0]))
                mp.put(edg[0], new HashMap<>());
            mp.get(edg[0]).put(edg[1], edg[2]);
        }
        
        //初始状态节点间距离都是无穷大
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        
        Set<Integer> determined=new HashSet<>();
        Set<Integer> undetermined=new HashSet<>();
        for(int i=0;i<n;i++){
            undetermined.add(i+1);
        }
        while(!undetermined.isEmpty()){
            int handlingNode;
            if(determined.isEmpty()){
                handlingNode=k;
            }           
        }
    }

    void dijkstra() {
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 使用「优先队列」存储所有可用于更新的点
        // 以 (点编号, 到起点的距离) 进行存储，优先弹出「最短距离」较小的点
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            // 每次从「优先队列」中弹出
            int[] poll = q.poll();
            int id = poll[0], step = poll[1];
            // 如果弹出的点被标记「已更新」，则跳过
            if (vis[id]) continue;
            // 标记该点「已更新」，并使用该点更新其他点的「最短距离」
            vis[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[id] + w[i]) {
                    dist[j] = dist[id] + w[i];
                    q.add(new int[]{j, dist[j]});
                }
            }
        }
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build graph
        final int INF = Integer.MAX_VALUE / 2;//?
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);//java8, 一维数组填充
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];//? determined set?
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}