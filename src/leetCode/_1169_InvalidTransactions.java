package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * A transaction is possibly invalid if:

    the amount exceeds $1000, or;
    if it occurs within (and including) 60 minutes of another transaction 
    with the same name in a different city.

Each transaction string transactions[i] 
consists of comma separated values representing 
the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, return a list of transactions that are possibly invalid.  
You may return the answer in any order.

 

Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: 
The first transaction is invalid 
because the second transaction occurs within a difference of 60 minutes, 
have the same name and is in a different city. 

Similarly the second one is invalid too.

Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]

Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]

["bob,689,1910,barcelona",
"alex,696,122,bangkok",
"bob,832,1726,barcelona",
"bob,820,596,bangkok",
"chalicefy,217,669,barcelona",
"bob,175,221,amsterdam"] 


["bob,627,1973,amsterdam",
"alex,387,885,bangkok",
"alex,355,1029,barcelona",
"alex,587,402,bangkok",
"chalicefy,973,830,barcelona",
"alex,932,86,bangkok",
"bob,188,989,amsterdam"]

Constraints:

    transactions.length <= 1000
    Each transactions[i] takes the form "{name},{time},{amount},{city}"
    Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
    Each {time} consist of digits, and represent an integer between 0 and 1000.
    Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */
public class _1169_InvalidTransactions {
	public static void main(String[] args) {
		String[] transactions=new String[]{
				"xnova,261,1949,chicago",
				"bob,206,1284,chicago",
				"xnova,420,996,bangkok",
				"chalicefy,704,1269,chicago",
				"iris,124,329,bangkok",
				"xnova,791,700,amsterdam",
				"chalicefy,572,697,budapest",
				"chalicefy,231,310,chicago",
				"chalicefy,763,857,chicago",
				"maybe,837,198,amsterdam",
				"lee,99,940,bangkok",
				"bob,132,1219,barcelona",
				"lee,69,857,barcelona",
				"lee,607,275,budapest",
				"chalicefy,709,1171,amsterdam"};
		/*
		 * ["xnova,261,1949,chicago",
		 * "bob,206,1284,chicago",
		 * "chalicefy,704,1269,chicago",
		 * "chalicefy,763,857,chicago",
		 * "lee,99,940,bangkok",
		 * "bob,132,1219,barcelona",
		 * "lee,69,857,barcelona",
		 * "chalicefy,709,1171,amsterdam"]



["bob,132,1219,barcelona",
"chalicefy,763,857,chicago",
"xnova,261,1949,chicago",
"chalicefy,709,1171,amsterdam",
"lee,69,857,barcelona",
"lee,99,940,bangkok",
"bob,206,1284,chicago",
"chalicefy,704,1269,chicago"]



["lee,99,940,bangkok",
"lee,69,857,barcelona",
"chalicefy,709,1171,amsterdam",
"chalicefy,704,1269,chicago",
"bob,206,1284,chicago",
"bob,132,1219,barcelona",
"xnova,261,1949,chicago"]

		 */

	}
    public List<String> invalidTransactions_0(String[] transactions) {
    	List<String> res=new ArrayList<>();
    	
    	Map<String,Deque<Pair1169>> map=new HashMap<>();	
    	Arrays.sort(transactions,(s1,s2)->{
    		String[] set1=s1.split(",");
    		String[] set2=s2.split(",");
    		
    		return Integer.parseInt(set1[1])-Integer.parseInt(set2[1]);
    	});
    	for(String trans:transactions) {
    		String[] strs=trans.split(",");
    		String name=strs[0];
    		int time=Integer.parseInt(strs[1]);
    		int amount=Integer.parseInt(strs[2]);
    		String city=strs[3];
    		Pair1169 p=new Pair1169(name,time,amount,city);
    		
    		if(map.containsKey(name)) {
    			Deque<Pair1169> s=map.get(name);
    			if(s.isEmpty()||s.peek().city.equals(city)||s.peek().time+60<time) {
    				s.push(new Pair1169(name,time,amount,city));
    	    	}else {
    				res.add(p.toString());
    				String lastCity=s.peek().city;
    				while(!s.isEmpty()) {
        				if(s.peek().city.equals(lastCity)&&time<=s.peek().time+60) {
        					res.add(s.pop().toString());
        				}else {
        					break;
        				}
        			}
    			}
    		}else {
    			Deque<Pair1169> s=new ArrayDeque<>();
    			s.offer(p);
        		map.put(name, s);
    		}
    	}
    	
    	for(Map.Entry<String, Deque<Pair1169>> e:map.entrySet()) {
    		Deque<Pair1169> s=e.getValue();
    		while(!s.isEmpty()) {
    			Pair1169 p=s.pop();
    			if(1000<p.amount) {
    				res.add(p.toString());
    			}
    		}
    	}
    	return res;
    }
    
    public List<String> invalidTransactions(String[] transactions) {
    	Map<String,List<Pair1169>> map=new HashMap<>();	
    	Arrays.sort(transactions,(s1,s2)->{
    		String[] set1=s1.split(",");
    		String[] set2=s2.split(",");
    		
    		return Integer.parseInt(set1[1])-Integer.parseInt(set2[1]);
    	});
    	for(String trans:transactions) {
    		String[] strs=trans.split(",");
    		String name=strs[0];
    		int time=Integer.parseInt(strs[1]);
    		int amount=Integer.parseInt(strs[2]);
    		String city=strs[3];
    		Pair1169 p=new Pair1169(name,time,amount,city);
    		
    		List<Pair1169> list=map.containsKey(name)?map.get(name):new ArrayList<>();
    		list.add(p);
    		map.put(name, list);
    	}
    	
    	Set<String> set=new HashSet<>();
    	for(Map.Entry<String, List<Pair1169>> e:map.entrySet()) {
    		List<Pair1169> list=e.getValue();
    		for(int i=0;i<list.size();i++) {
    			Pair1169 p=list.get(i);
    			for(int j=0;j<list.size();j++) {
    				if(i==j)
    					continue;
    				Pair1169 p2=list.get(j);
    				if(!p.city.equals(p2.city)&&Math.abs(p.time-p2.time)<=60) {
    					set.add(p.toString());
    					set.add(p2.toString());
    				}
    			}
    		}
    		
    		for(int i=0;i<list.size();i++) {
    			
    			if(1000<list.get(i).amount) {
    				set.add(list.get(i).toString());
    			}
    		}
    	}
    	
    	return new ArrayList<String>(set);
    }
}

class Pair1169{
	String name;
	int time;
	int amount;
	String city;
	
	public Pair1169(String name,int time,int amount,String city) {
		this.name=name;
		this.time=time;
		this.amount=amount;
		this.city=city;
	}
	
	@Override
	public String toString() {
		return "" + name + "," + time + "," + amount + "," +city +"";
	}
}
