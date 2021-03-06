package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _472_ConcatanatedWords {
    /*
     * A concatenated word is defined as a string 
     * that is comprised entirely of at least two shorter words 
     * in the given array.
     * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
     */
	
	public static void main(String[] args) {
		_472_ConcatanatedWords c=new _472_ConcatanatedWords();
		List<String> res=c.findAllConcatenatedWordsInADict(
				new String[] {"cat","cats","catsdogcats",
						"dog","dogcatsdog","hippopotamuses",
						"rat","ratcatdogcat"});
		
		System.out.println(res);
	}

	Set<String> dict=new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words==null) 
        	return null;
    
        dict.addAll(Arrays.asList(words));
        List<String> res=new ArrayList<>();
        
        if(words.length==1&&words[0].equals("")) 
        	return res;
            
        for(String word:words){
            if(canBreak(word,0,0))
                res.add(word);
        }
        return res;
    }
    
    
    //["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
    private boolean canBreak(String word,int lo,int cnt){
        if(lo==word.length()) {
        	//how to exclude itself.
        	return 1<cnt;
        }
        
        for(int i=lo;i<word.length();i++){
            if(dict.contains(word.substring(lo,i+1))){
                boolean res=canBreak(word,i+1,cnt+1);
                if(res){
                    return true;
                }
            }
        }
        
        return false;
    }
}
