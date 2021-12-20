package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
    /*
     * ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
       [[],              [0],     [1],     [0],     [2],     [1],     []]
       
       ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"] 
       [[],              [0],     [0],     [0],     [],         [0],     [0]] 

     */
public class _380_InsertDeleteGetRandom {
	public static void main(String[] args) {



	}
	
	List<Integer> list;
	Map<Integer,Integer> valIndexMap;

	public _380_InsertDeleteGetRandom() {
    	list=new ArrayList<>();
    	valIndexMap=new HashMap<>();
    }
	
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(valIndexMap.containsKey(val)) {
    		return false;
    	}else {
    		list.add(val);//0   
        	valIndexMap.put(val, list.size()-1);//0,0   
    		return true;
    	}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!valIndexMap.containsKey(val)){
    		return false;
    	}else {
    		if(list.size()==1) {
    			list.clear();
    			valIndexMap.clear();
    		}else {
    			int index=valIndexMap.get(val);//0
            	int lastVal=list.get(list.size()-1);//0
            	list.set(index, lastVal);//0
            	list.remove(list.size()-1);//1
            	valIndexMap.remove(val);//1,1
            	valIndexMap.put(lastVal, index);//the place of this line!!!
    		}
        	return true;
    	}
    	
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random r=new Random();
    	int i=r.nextInt(list.size());
    	return list.get(i);
    }
}