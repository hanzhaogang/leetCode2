package bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
public class TopK {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        
        TopK m=new TopK();
        m.query("a");
        m.query("b");
        System.out.println(m.topK(1));
        m.query("c");
        m.query("b");
        System.out.println(m.topK(2));
        System.out.println("Hello World!");
        
        
//       PriorityQueue<Map.Entry<Integer,List<String>>> pq=new PriorityQueue<>(
//        		(e1,e2)->Integer.compare(e1.getKey(), e2.getKey()));
        
    }
    
    Map<Integer,List<String>> countWords=new TreeMap<>(
    		(e1,e2)-> Integer.compare(e2,e1));
    Map<String,Integer> wordCount=new HashMap<>();
    
    public void query(String str){//byte dance
        
    	 int preCount=wordCount.getOrDefault(str,0);//1
         wordCount.put(str,preCount+1);//b,2
    	
        if(wordCount.get(str)!=1){//b
            List<String> list=countWords.get(preCount);//a c b
            int index=0;
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(str)){
                    index=i;
                }
            }
            list.remove(index);//a,c
            countWords.put(preCount,list);
        } 
//      int curCount=preCount++;//2!!!!!!!!!!!!!!!!!!!!!!!
        int curCount=preCount+1;
        List<String> list2=countWords.getOrDefault(curCount, 
        		new ArrayList<String>());
        list2.add(str);
        countWords.put(curCount,list2);//2,b    
    }
    
    public List<String> top(int k){//100,80//2
        List<String> res=new ArrayList<>();
        
        for(Map.Entry<Integer,List<String>> e: countWords.entrySet()){
            List<String> list=e.getValue();//b
            for(int i=list.size()-1;
            		list.size()-Math.min(list.size(),k)<=i;i--){//
                res.add(list.get(i));
            }
            
            k-=list.size();
            
            if(k<=0){
                break;
            }
        }
        
        return res;
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    PriorityQueue<Pair> heap=new PriorityQueue<>((p1,p2)-> {
    	if(p1.count.equals(p2.count)) {
    		return Integer.compare(p2.time, p1.time);
    	}else {
    		return Integer.compare(p2.count, p1.count);
    	}
    });
    
    Map<String,Pair> map=new HashMap<>();
    public void query2(String word) {
    	if(map.containsKey(word)) {
    		heap.remove(map.get(word));//O(n)
    	}
    }
    
    public List<String> top2(int k){//2 * k * lg n
    	List<String> res=new ArrayList<>();
    	List<Pair> topKPair=new ArrayList<>();
    	for(int i=0;i<k;i++) {
    		Pair pair=heap.poll();
    		res.add(pair.word);
    	}
    	
    	for(Pair p:topKPair) {
    		heap.offer(p);
    	}
    	return res;
    }
    
    
}


class Pair{
	String word;
	Integer count;
	Integer time;
}