package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 

    A tree rooted at node 0 is given as follows:

        The number of nodes is nodes;
        The value of the i-th node is value[i];
        The parent of the i-th node is parent[i].

    Remove every subtree whose sum of values of nodes is zero.

    After doing so, return the number of nodes remaining in the tree. 

    Example 1:

    Input: 
    nodes = 7, 
    parent = [-1,0,0,1,2,2,2], 
    value =  [1,-2,4,0,-2,-1,-1]
    Output: 2

    Constraints:

        1 <= nodes <= 10^4
        -10^5 <= value[i] <= 10^5
        parent.length == nodes
        parent[0] == -1 which indicates that 0 is the root.


 */
public class _1273_deleteTreeNodes {
	Map<Integer,List<Integer>> children;
	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
		children=new HashMap<>();
		for(int i=0;i<parent.length;i++) {
			List<Integer> childList=children.getOrDefault(parent[i], 
					new ArrayList<Integer>());
			childList.add(i);
			children.put(parent[i], childList);
		}
		
		inorder(0,parent,value);
		int res=0;
		for(int v:value) {
			if(v==0) {
				
			}
		}
		return res;
	}
	
	private void postOrder(int curIndex,int[] parent,int[] value){
		if(children.containsKey(curIndex)) {
			return;
		}
		
		
		for(int child:children.get(curIndex)) {
			postOrder(child,parent,value);
		}
		
		
	}
}
