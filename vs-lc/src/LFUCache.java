import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LFUCache {
    Map<Integer,Integer> cache;
    Map<Integer,Integer> useCount;
    Map<Integer,Set<Integer>> countKeysMap;
    int capacity;
    int min=-1;
    
    public LFUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<Integer,Integer>();
        useCount=new HashMap<Integer,Integer>();
        countKeysMap=new HashMap<Integer,Set<Integer>>();
    }
    
    public int get(int key) {
        if(cache.keySet().contains(key)){
            //update useCount
        	int oldCount=useCount.get(key);
        	int newCount=oldCount+1;
        	useCount.put(key, newCount);
            //update countKeysMap
        	Set<Integer> keys=countKeysMap.getOrDefault(newCount, new LinkedHashSet<>());
        	keys.add(key);
            countKeysMap.put(newCount, keys); 
            Set<Integer> oldKeys=countKeysMap.get(oldCount);
            oldKeys.remove(key);
            if(oldCount==min&&oldKeys.size()==0)
            	min++;
            return cache.get(key);
        }else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(capacity<=0) return;
        
    	if(cache.size()==capacity) {
    		Integer evit=countKeysMap.get(min).iterator().next();
    		cache.remove(evit);
    		useCount.remove(evit);
    	}
        cache.put(key,value);
        if(!cache.containsKey(key)) {
        	useCount.put(key, 1);
           	if(min==-1) min=1;
           	Set<Integer> keys=countKeysMap.getOrDefault(1, new LinkedHashSet<>());
           	keys.add(key);
           	countKeysMap.put(1, keys);
        }else {
        	//get?
        	int oldCount=useCount.get(key);
        	int newCount=oldCount+1;
        	useCount.put(key,newCount);
        	Set<Integer> keys=countKeysMap.getOrDefault(newCount, new LinkedHashSet<>());
           	keys.add(key);
               countKeysMap.put(newCount, keys); 
               Set<Integer> oldKeys=countKeysMap.get(oldCount);
               oldKeys.remove(key);
               if(oldCount==min&&oldKeys.size()==0)
               	min++;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */