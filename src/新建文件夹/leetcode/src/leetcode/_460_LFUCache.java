package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _460_LFUCache {
/*
 * Design and implement a data structure for 
 * Least Frequently Used (LFU) cache. 
 * It should support the following operations: get and put.

get(key) - 

Get the value (will always be positive) of the key 
if the key exists in the cache, 
otherwise return -1.

put(key, value) - 
Set or insert the value if the key is not already present. 
When the cache reaches its capacity, 
it should invalidate the least frequently used item 
before inserting a new item. 

For the purpose of this problem, 
when there is a tie (i.e., two or more keys that have the same frequency), 
the least recently used key would be evicted.

Note that the number of times an item is used 
is the number of calls to the get and put functions for that item 
since it was inserted. 
This number is set to zero when the item is removed.

 

Follow up:
Could you do both operations in O(1) time complexity?

 

Example:

LFUCache cache = new LFUCache( 2 // capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
	
	public static void main(String[] args) {
		_460_LFUCache cache=new _460_LFUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
//		_460_LFUCache cache=new _460_LFUCache(3); 
//		cache.put(2, 2);
//		cache.put(1, 1);
//		cache.get(2);   
//		cache.get(1);   
//		cache.get(2);   
//		cache.put(3, 3);//
//		cache.put(4, 4);
//		cache.get(3);//-1   
//		cache.get(2);   
//		cache.get(1);   
//		cache.get(4);   
	}
	
	
	Map<Integer,Pair460> key2pair;
	TreeMap<Pair460,Integer> pair2Key;
	int cap;
	int time;
	public _460_LFUCache(int capacity) {
		key2pair=new HashMap<Integer,Pair460>();
		pair2Key=new TreeMap<Pair460,Integer>((p1,p2)->{
			if(p1.fre!=p2.fre) {
				return p1.fre-p2.fre; 
			}else {
				return p1.time-p2.time;
			}
		});
		cap=capacity;
		time=0;
    }
    
    public int get(int key) {
        if(cap==0)
            return -1;
    	if(!key2pair.containsKey(key))
    		return -1;
    	Pair460 p=key2pair.get(key);
        pair2Key.remove(p);
    	Pair460 newP=new Pair460(p.value,++p.fre,++time);
		key2pair.put(key, newP);
		pair2Key.put(newP, key);
    	return p.value;
    }
    
    public void put(int key, int value) {
        if(cap==0)
            return;
        
        if(key2pair.containsKey(key)) {
        	Pair460 p=key2pair.get(key);
            int key2=pair2Key.remove(p);
            Pair460 newP=new Pair460(value,++p.fre,++time);
            
    		key2pair.put(key, newP);
    		pair2Key.put(newP, key);
    	}else {
            if(key2pair.size()==cap) {
    		    Map.Entry<Pair460,Integer> e=pair2Key.pollFirstEntry();
    			key2pair.remove(e.getValue());
    		}
    	
    		Pair460 newP=new Pair460(value,1,++time);
    		key2pair.put(key, newP);
    		pair2Key.put(newP, key);
    	}
    }
}


	
class Pair460{
	int value;
	int fre;
	int time;
	
	public Pair460(int val,int fre,int time) {
		this.value=val;
		this.fre=fre;
		this.time=time;
	}
	
	
	
		
	public String toString() {
		return "val:"+value+" fre:"+fre+" time:"+time;
	}
}