package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 * In a directed graph, we start at some node and every turn, 
 * walk along a directed edge of the graph.  
 * If we reach a node that is terminal 
 * (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe 
if and only if we must eventually walk to a terminal node.  
More specifically, there exists a natural number K 
so that for any choice of where to walk, 
we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

    graph will have length at most 10000.
    The number of edges in the graph will not exceed 32000.
    Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
public class _802_findEventualSafeStates {
	public static void main(String[] args) {
		int[][] graph=new int[][] {{1,2},{2,3},{5},{0},{5},{},{}};
//		int[][] graph=new int[][] {{},{0,2,3,4},{3},{4},{}};
//		int[][] graph=new int[][] {{1,2,4},{0,2,4},{3,4},{4},{2}};
		_802_findEventualSafeStates s=new _802_findEventualSafeStates();
		System.out.println(s.eventualSafeNodes(graph));
	}
	
	int[] nodeStatus;//0 undetermined; 1 safe; -1 not safe; 2 visited.
	public List<Integer> eventualSafeNodes(int[][] graph) {
		nodeStatus=new int[graph.length];
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
        	if(nodeStatus[i]==0) {
        		dfs(i,graph);
        	}
        }
        
        for(int i=0;i<nodeStatus.length;i++) {
        	if(nodeStatus[i]==1) {
        		safeNodes.add(i);
        	}
        }
        return safeNodes;
    }
    
    private boolean dfs(int curNode,int[][] graph){
    	nodeStatus[curNode]=2;
        int[] nbs=graph[curNode];//1,2
        for(int nb:nbs){
        	boolean safeNb=false;
        	if(nodeStatus[nb]==-1||nodeStatus[nb]==2) {
        		safeNb=false;
        	}
        		
        	if(nodeStatus[nb]==0)
        		safeNb=dfs(nb,graph);
        	else if(nodeStatus[nb]==1) {
        		safeNb=true;
        	}
        	
        	if(!safeNb) {
        		nodeStatus[curNode]=-1;
        		return false;
        	}
        }
        
   		nodeStatus[curNode]=1;
        return true;
    }
}