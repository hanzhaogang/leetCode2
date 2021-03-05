package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a list accounts, each element accounts[i] is a list of strings, 
 * where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. 
Two accounts definitely belong to the same person if there is some email that is common to both accounts. 
Note that even if two accounts have the same name, they may belong to different people as people could have the same name. 
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: 
the first element of each account is the name, and the rest of the elements are emails in sorted order. 
The accounts themselves can be returned in any order.

Example 1:

Input: 
accounts = [ ["John", "johnsmith@mail.com", "john00@mail.com"], 
             ["John", "johnnybravo@mail.com"], 
             ["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
             ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
         ["John", "johnnybravo@mail.com"], 
         ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

Note:
The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 */
public class _721_accountMerge {
	public static void main(String[] args) {
		List<List<String>> accounts=Arrays.asList(
				Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
				Arrays.asList("John", "johnnybravo@mail.com"),
				Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
				Arrays.asList("Mary", "mary@mail.com"));
		_721_accountMerge s=new _721_accountMerge();
		System.out.println(s.accountsMerge(accounts));
	}
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	Map<String,List<String>> graph=new HashMap<>();
    	for(List<String> account:accounts) {
    		String name=account.get(0);
    		for(int i=1;i<account.size();i++) {
    			graph.put(name+","+account.get(i), new ArrayList<>());
    		}
    	}
    	
    	for(List<String> account:accounts) {
    		String name=account.get(0);
    		String account1=account.get(1);
    		List<String> nbs=graph.get(name+","+account1);
    		for(int i=2;i<account.size();i++) {
    			nbs.add(name+","+account.get(i));
    			
    			graph.get(name+","+account.get(i)).add(name+","+account1);
    		}
    	}
    	
    	List<List<String>> res=new ArrayList<>();
    	Set<String> visited=new HashSet<>();
    	for(Map.Entry<String, List<String>> e:graph.entrySet()) {
    		String curNode=e.getKey();
    		if(!visited.contains(curNode)){
    			List<String> curIsland=new ArrayList<>();
    			curIsland.add(curNode.split(",")[0]);
    			dfs(graph,curNode,visited,curIsland,res);
    			Collections.sort(curIsland);
    			res.add(curIsland);
    		}
    	}
    	return res;
    }
    
    private void dfs(Map<String,List<String>> graph,String curNode,Set<String> visited,
    						List<String> curIsland,List<List<String>> res) {
    	
    	visited.add(curNode);
    	curIsland.add(curNode.split(",")[1]);
    	
    	List<String> nbs=graph.get(curNode);
    	for(String nb:nbs) {
    		if(!visited.contains(nb))
    			dfs(graph,nb,visited,curIsland,res);
    	}
    }
}

class Node721{
	String name;
	String mail;
	public Node721(String name,String mail) {
		this.name=name;
		this.mail=mail;
	}
}