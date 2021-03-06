package leetCode;

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


public class LFUCache {
    private Map<Integer, LFUCacheNode> map;
    private Map<Integer, LFUCacheDbLinkedList> freqMap;
    private int size, capacity, minF; // minF 当前最低频率

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, new LFUCacheDbLinkedList()); // 默认开一个频率为 1 的链表
        this.capacity = capacity;
        size = 0;
        minF = 1; // 当前最低频率 1
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            LFUCacheNode node = map.get(key);
            res = node.value;
            useOnce(node); // 封装更新节点频率的所有操作
        }
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // exist
            LFUCacheNode node = map.get(key);
            node.value = value; // 别忘了更新值
            useOnce(node); // 封装更新节点频率的所有操作
            return;
        }

        // not exist
        // 新建节点
        LFUCacheNode newOne = new LFUCacheNode(key, value);
        map.put(key, newOne);
        // 加入频率 1 的链表
        LFUCacheDbLinkedList list1 = freqMap.get(1);
        list1.add(newOne);
        if (size == capacity) {
            // 挤出 当前最低频率 里的最后一个
            LFUCacheDbLinkedList listMin = freqMap.get(minF);
            LFUCacheNode removed = listMin.removeLast();
            // 【易漏】移除数据映射
            map.remove(removed.key);
        } else size++;

        // 【易漏】更新当前最低频率
        minF = 1;
    }

    // 封装更新节点频率的所有操作
    private void useOnce(LFUCacheNode node) {
        // 原来频率的链表
        LFUCacheDbLinkedList oriList = freqMap.get(node.freq);
        oriList.remove(node);

        // 新的频率
        int newF = node.freq + 1;
        // 【易错】若旧链表里已经清空，则更新当前最低频率
        if (minF == node.freq && oriList.isEmpty()) minF = newF;

        // 新频率的链表增加节点
        if (!freqMap.containsKey(newF)) freqMap.put(newF, new LFUCacheDbLinkedList());
        LFUCacheDbLinkedList newList = freqMap.get(newF);
        newList.add(node);

        // 更新节点频率
        node.freq = newF;
    }
}



class LFUCache {
    Map<Integer,Integer> key2value;
    Map<Integer,Integer> key2fre;
    Map<Integer,Set<Integer>> fre2Keys;
    int capacity;
    int min;
    
    public LFUCache(int capacity) {
        this.capacity=capacity;
        key2value=new HashMap<Integer,Integer>();
        key2fre=new HashMap<Integer,Integer>();
        key2Keys=new HashMap<Integer,Set<Integer>>();
        min=-1;
        //countKeysMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!key2value.containsKey(key))
            return -1;
        
        //update key2fre
        int oldFre=key2fre.get(key);
        int newFre=oldFre+1;
        useCount.put(key, newCount);
        //update countKeysMap
        Set<Integer> keys=countKeysMap.getOrDefault(newCount, new LinkedHashSet<>());
        keys.add(key);
        countKeysMap.put(newCount, keys); 
        Set<Integer> oldKeys=countKeysMap.get(oldCount);
        oldKeys.remove(key);
        if(oldCount==min&&oldKeys.size()==0)
        	min++;//?
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity<=0) return;
        
        if(cache.containsKey(key)){//if contains, even if reach the size limit, still no evit.
            cache.put(key,value);
        	get(key);//get?
            return;
        }
    	if(capacity<=cache.size()) {//==?
    		Integer evit=countKeysMap.get(min).iterator().next();
    		cache.remove(evit);
    		useCount.remove(evit);//
            Set<Integer> keys=countKeysMap.get(min);
            keys.remove(evit);
            //if(keys.size()==0) countKeysMap.remove(min);
    	}
        
        cache.put(key,value);
        	useCount.put(key, 1);
           	//if(min==-1) min=1;
            min=1;
           	Set<Integer> keys=countKeysMap.getOrDefault(1, new LinkedHashSet<>());
           	keys.add(key);
           	countKeysMap.put(1, keys);
        
        return;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

