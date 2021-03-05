package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

 

Constraints:

    transactions.length <= 1000
    Each transactions[i] takes the form "{name},{time},{amount},{city}"
    Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
    Each {time} consist of digits, and represent an integer between 0 and 1000.
    Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */
public class _1169_InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
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
    		
    		if(map.containsKey(name)) {
    			Deque<Pair1169> s
    		}else {
    			Deque<Pair1169> s=new ArrayDeque<>();
    			s.offer(new Pair1169(name,time,amount,city));
    			map.put(name, s);
    		}
    	}
    	
    	for(Map.Entry<String, Deque<Pair1169>> e:map.entrySet()) {
    		Deque<Pair1169> s=e.getValue();
    		while(!s.isEmpty()) {
    			res.add(s.poll().toString());
    		}
    	}
    	
    	return res;
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
		return "[" + name + "," + time + "," + amount + "," +city +"]";
	}
}
