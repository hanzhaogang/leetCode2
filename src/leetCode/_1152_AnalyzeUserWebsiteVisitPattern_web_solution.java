package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1152_AnalyzeUserWebsiteVisitPattern_web_solution {
	public List<String> mostVisitedPattern(String[] username, 
											int[] timestamp, 
											String[] website) {
        int n = username.length;
        List<Pair> datas = new ArrayList<>();
        for(int i = 0; i < n; i++){
            datas.add(new Pair(username[i], timestamp[i], website[i]));
        }
        
        //use pair is more clear. It hsa `time` field.
        Collections.sort(datas, (a, b) -> a.time - b.time);

        Map<String, List<String>> user2WebVisits = new HashMap<>();
        for(Pair data : datas){
        	user2WebVisits.putIfAbsent(data.user, new ArrayList<String>());
        	user2WebVisits.get(data.user).add(data.web);
        }
        
        Map<String, Integer> seqToCount = new HashMap<>();
        
        int maxCount = 0;
        String maxSeq = "";
        for(Map.Entry<String, List<String>> entry : 
        			user2WebVisits.entrySet()){
            Set<String> seqCom = getCom(entry.getValue());
            for(String seq : seqCom){
                seqToCount.put(seq, seqToCount.getOrDefault(seq, 0) + 1);
                if(seqToCount.get(seq) > maxCount){
                    maxCount = seqToCount.get(seq);
                    maxSeq = seq;
                }else if(seqToCount.get(seq) == maxCount && 
                				seq.compareTo(maxSeq) < 0){
                    maxSeq = seq;
                }    
            }
        }
        
        List<String> res = new ArrayList<>();
        String [] webs = maxSeq.split(",");
        for(String w : webs){
            res.add(w);
        }
        return res;
    }
    
    private HashSet<String> getCom(List<String> webVisits){
        HashSet<String> res = new HashSet<>();
        int n = webVisits.size();
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    res.add(webVisits.get(i) + "," + 
                    		webVisits.get(j) + "," + 
                    		webVisits.get(k));
                }
            }
        }
        
        return res;
    }
}

class Pair{
    String user;
    int time;
    String web;
    public Pair(String user, int time, String web){
        this.user = user;
        this.time = time;
        this.web = web;
    }
}