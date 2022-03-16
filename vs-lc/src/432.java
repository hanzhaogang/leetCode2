import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class 432 {
	
}

/* 2个错误，一个自己看出来了，就是inc的时候，oldSet可能为空。但是在修改的时候还是没完全改对。
一个是在getMaxKey的时候，i2s有可能为空。 */
class AllOne {
    Map<String,Integer> s2i;
    TreeMap<Integer,Set<String>> i2s; 
    public AllOne() {
        s2i=new HashMap<String,Integer>();
        i2s=new TreeMap<Integer,Set<String>>();
    }
    
    public void inc(String key) {
        int oldCount=s2i.getOrDefault(key, 0);
        s2i.put(key,oldCount+1);

        Set<String> oldSet=i2s.getOrDefault(oldCount,null);
        if(oldSet!=null){
            oldSet.remove(key);
            if(oldSet.isEmpty()){
                i2s.remove(oldCount);
            }
        }

        Set<String> set=i2s.getOrDefault(oldCount+1, new HashSet<String>());
        set.add(key);
        i2s.put(oldCount+1, set);
    }
    
    public void dec(String key) {
        int oldCount=s2i.get(key);
        if(oldCount-1==0){
            s2i.remove(key);
        }else{
            s2i.put(key,oldCount-1);
        }

        Set<String> oldSet=i2s.get(oldCount);
        oldSet.remove(key);
        if(oldSet.isEmpty()){
            i2s.remove(oldCount);
        }
        
        if(oldCount-1!=0){
            Set<String> set=i2s.getOrDefault(oldCount-1, new HashSet<String>());
            set.add(key);
            i2s.put(oldCount-1, set);
        }
    }
    
    public String getMaxKey() {
        if(i2s.isEmpty())
            return "";
        return i2s.get(i2s.lastKey()).iterator().next();
    }
    
    public String getMinKey() {
        if(i2s.isEmpty())
            return "";
        return i2s.get(i2s.firstKey()).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */