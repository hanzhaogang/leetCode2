package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _139_wordBreak {
    Map<String,Boolean> memo=new HashMap<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        /*leetcode     *[leet,code] can word be used multiple times? yes 
         * leetcode [leetcode]*/
        Set<String> set=new HashSet<>(wordDict);
        return helper(s,set);
    }
    
    
    private boolean helper(String s,Set<String> set){
        if(s.equals("")) 
            return true;
        
        if(memo.containsKey(s)) 
            return memo.get(s);
        
        for(String str:set){/*if loop from s.charSet() will tle without memo.*/
        
            if(s.startsWith(str)){
                boolean res=helper(s.substring(str.length()),set);
                if(res){
                    memo.put(s,true);
                    return true;
                }
            }
        }
        
        memo.put(s,false);
        return false;
    }
}