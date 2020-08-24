package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a list of airline tickets 
 * represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. 
 * All of the tickets belong to a man who departs from JFK. 
 * Thus, the itinerary must begin with JFK.

Note:

    If there are multiple valid itineraries, 
    you should return the itinerary that has the smallest lexical order 
    when read as a single string. 
    
    For example, 
    the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    One must use all the tickets once and only once.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:

Input: 
[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],
["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is 
["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 */
public class _332_reconstructItineray {
	public static void main(String[] args) {
//		List<List<String>> tickets=Arrays.asList(Arrays.asList("MUC","LHR"),
//				                                 Arrays.asList("JFK","MUC"),
//				                                 Arrays.asList("SFO","SJC"),
//				                                 Arrays.asList("LHR","SFO"));
		List<List<String>> tickets=Arrays.asList(Arrays.asList("JFK","SFO"),
												Arrays.asList("JFK","ATL"),
												Arrays.asList("SFO","ATL"),
												Arrays.asList("ATL","JFK"),
												Arrays.asList("ATL","SFO"));
		_332_reconstructItineray s=new _332_reconstructItineray();
		System.out.println(s.findItinerary(tickets));
	}
	int resLen;
	boolean found;
	List<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
    	Map<String,List<String>> graph=new HashMap<>();
    	for(List<String> ticket:tickets) {
    		String src=ticket.get(0);
    		String des=ticket.get(1);
    		List<String> nbs=graph.getOrDefault(src, 
    				new ArrayList<String>());
    		nbs.add(des);
    		graph.putIfAbsent(src, nbs);
    	}
    	
    	for(Map.Entry<String, List<String>> e:graph.entrySet()) {
    		List<String> list=e.getValue();
    		Collections.sort(list,(s1,s2)->{return s1.compareTo(s2);});
    	}
    	
    	List<String> res=new ArrayList<>();
    	res.add("JFK");
    	resLen=tickets.size()+1;
    	Map<String,Integer> leftCounts=new HashMap<>();
    	for(List<String> list:tickets) {
    		String keyStr=list.get(0)+","+list.get(1);
    		leftCounts.put(keyStr,
    				leftCounts.getOrDefault(keyStr, 0)+1);
    	}
    	bt("JFK",res,graph,resLen,leftCounts);
    	return ans;
    }
    
    private void bt(String src,
    				List<String> res,
    				Map<String,List<String>> graph,
    				int resLen,
    				Map<String,Integer> leftCounts) {
    	if(found)
    		return;
    	
    	if(graph.get(src)==null) {
    		if(res.size()==resLen&&!found) {
        		ans=new ArrayList<String>(res);
        		found=true;
        	}
    		return;
    	}
    	
    	
    	List<String> nbs=graph.get(src);
    	for(String nb:nbs){
    		String str=src+","+nb;
    		if(0<leftCounts.get(str)) {
    			res.add(nb);
        		leftCounts.put(str,leftCounts.get(str)-1);
        		bt(nb,res,graph,resLen,leftCounts);
        		res.remove(res.size()-1);
        		leftCounts.put(str,leftCounts.get(str)+1);
    		}
    	}
    	
    	if(res.size()==resLen&&!found) {
    		ans=new ArrayList<String>(res);
    		found=true;
    	}
    }
}

//class Solution332 {
//    public List<String> findItinerary(List<List<String>> tickets) {
//        // 因为逆序插入，所以用链表
//        List<String> ans = new LinkedList<>();
//        if (tickets == null || tickets.size() == 0)
//            return ans;
//        Map<String, List<String>> graph = new HashMap<>();
//        for (List<String> pair : tickets) {
//            // 因为涉及删除操作，我们用链表
//            List<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
//            nbr.add(pair.get(1));
//        }
//        // 按目的顶点排序
//        graph.values().forEach(x -> x.sort(String::compareTo));
//        visit(graph, "JFK", ans);
//        return ans;
//    }
//    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
//    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
//        List<String> nbr = graph.get(src);
//        while (nbr != null && nbr.size() > 0) {
//            String dest = nbr.remove(0);
//            visit(graph, dest, ans);
//        }
//        ans.add(0, src); // 逆序插入
//    }
//}