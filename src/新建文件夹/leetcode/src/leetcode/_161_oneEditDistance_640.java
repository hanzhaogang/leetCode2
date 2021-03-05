package leetcode;
/*
 * Given two strings S and T, 
 * determine if they are both one edit distance apart.
One edit distance means doing one of these operation:

    insert one character in any position of S
    delete one character in S
    change one character in S to other character

Example 1:

Input: s = "aDb", t = "adb" 
Output: true

Example 2:

Input: s = "ab", t = "ab" 
Output: false
Explanation:
s=t ,so they aren't one edit distance apart


 */
public class _161_oneEditDistance_640 {
    public boolean isOneEditDistance(String s, String t) {
    	if(1<Math.abs(s.length()-t.length()))
    		return false;
    	
    	if(s.length()==t.length()) {
    		int diffCount=0;
    		for(int i=0;i<s.length();i++) {
    			if(s.charAt(i)!=t.charAt(i)) {
    				diffCount++;
    				if(1<diffCount) {
    					return false;
    				}
    			}
    		}
    		if(diffCount==1)
    			return true;
    		else
    			return false;
    	}
    	
    	int minLen=Math.min(s.length(), t.length());
    	int diffCount=0;
    	for(int i=0,j=0;i<minLen;i++,j++) {
    		if(s.charAt(i)!=t.charAt(j)&&diffCount==0) {
    			if(s.length()<t.length())
    				j++;
    			else
    				i++;
    			if(s.charAt(i)!=t.charAt(j))
    				return false;
    		}else if(s.charAt(i)!=t.charAt(j)){
    			return false;
    		}
    	}
    	return true;
    }
}
