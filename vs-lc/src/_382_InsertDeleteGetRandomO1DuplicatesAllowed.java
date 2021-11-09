import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
 * Design a data structure that supports all following operations in average O(1) time.
Note: Duplicate elements are allowed.

    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements. 
    The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 */
public class _382_InsertDeleteGetRandomO1DuplicatesAllowed {
	List<Integer> valList;
	Map<Integer,Set<Integer>> val2indexs;
	Random r;
	/*
	 * ["RandomizedCollection","insert","insert","remove","insert","remove","getRandom"]
[[],[0],[1],[0],[2],[1],[]]
	 */
    /** Initialize your data structure here. */
    public RandomizedCollection() {
    	valList=new ArrayList<>();
    	val2indexs=new HashMap<Integer,Set<Integer>>();
    	r=new Random();
    }
    
    /** Inserts a value to the collection. 
     * Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	valList.add(val);
    	
    	Set<Integer> indexSet=val2indexs.getOrDefault(val, new HashSet<Integer>());
    	indexSet.add(valList.size()-1);
    	val2indexs.put(val, indexSet);
    	
    	return indexSet.size()==1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if(!val2indexs.containsKey(val))
    		return false;
    	
    	Set<Integer> indexSet=val2indexs.get(val);
    	int removedIndex=indexSet.iterator().next();
    	indexSet.remove(removedIndex);
    	if(indexSet.size()==0) {
    		val2indexs.remove(val);
    	}
    	
    	int lastVal=valList.get(valList.size()-1);
    	valList.set(removedIndex, lastVal);
    	int lastIndex=valList.size()-1;
    	valList.remove(lastIndex);
    	
    	Set<Integer> lastIndexSet=val2indexs.get(lastVal);
    	if(lastIndexSet!=null) {
    		lastIndexSet.add(removedIndex);
    		lastIndexSet.remove(lastIndex);
    	}
    	return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	int index=r.nextInt(valList.size());
    	return valList.get(index);
    }
}


class RandomizedCollection {
    int n ;//当前集合大小
    HashMap<Integer,Set<Integer>>map;
    ArrayList<Integer>list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.random = new Random();
        this.map = new HashMap();
        this.n = 0;
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. 
     * Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set set = map.get(val);
        if(set==null)   set = new HashSet<>();
        set.add(n);//添加索引
        list.add(val);
        map.put(val, set);
        n++;
        return set.size()==1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int lastIndex = n-1;//得到最后2个值索引
            Set lastset = map.get(list.get(lastIndex));
            Set set = map.get(val);
            int currIndex = (int)set.iterator().next();//得到当前值索引
            //进行删除操作
            swap(list, currIndex, lastIndex);
            list.remove(n-1);//将其在列表中删除
            set.remove(currIndex);//删除原值
            if(set.size()==0)   map.remove(val);//在图中删除
            //修改最后一个值的索引
            lastset.remove(n-1);
            lastset.add(currIndex);
            n--;
        }else{
            return false;
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(n));
    }
    private void swap(List<Integer> list ,int i,int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */