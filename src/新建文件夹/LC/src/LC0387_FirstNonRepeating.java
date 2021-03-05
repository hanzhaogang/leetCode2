import java.util.HashSet;

public class LC0387_FirstNonRepeating {

}



/*
 * leetcode
 */
class Solution0387 {
    public int firstUniqChar(String s) {
        /*int[] counts = new int[26];
        int[] firstIndex=new int[26];
        
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
            counts[c-'a']++;
            if(firstIndex[c-'a']==0)
            	firstIndex[c-'a']=i+1;//
        }
        
        int res=Integer.MAX_VALUE;
        for(int i=0;i<counts.length;i++) {
        	if(counts[i]==1&&firstIndex[i]-1<res)
        		res=firstIndex[i]-1;
        }
        
        return res==Integer.MAX_VALUE?-1:res;*/
    	
    	int[] freq=new int[26];
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		freq[c-'a']++;
    	}
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(freq[c-'a']==1)
    			return i;
    	}
    	return -1;
    }
}
