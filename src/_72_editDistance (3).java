package leetCode;

/*
 * Given two words word1 and word2, 
 * find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class _72_editDistance {
    public int minDistance(String word1, String word2) {
//    	return dfs(word1,word2,word1.length()-1,word2.length()-1);
    	int len1=word1.length();
    	int len2=word2.length();
    	
    	if(len1==0||len2==0) {
    		return Math.max(len1, len2);
    	}
    	
    	int[][] dp=new int[len1+1][len2+1];
    	for(int i1=0;i1<len1+1;i1++) {
    		dp[i1][0]=i1;
    	}
    	for(int i2=0;i2<len2+1;i2++) {
    		dp[0][i2]=i2;
    	}
    	
    	for(int i1=1;i1<len1+1;i1++) {
    		for(int i2=1;i2<len2+1;i2++) {
    			if(word1.charAt(i1-1)==word2.charAt(i2-1)) {
    				dp[i1][i2]=dp[i1-1][i2-1];
    			}else {
    				dp[i1][i2]= Math.min(Math.min(dp[i1-1][i2-1],
    						dp[i1-1][i2]),dp[i1][i2-1])+1;
    			}
    		}
    	}
    	
    	return dp[len1][len2];
    }
    
    private int dfs(String word1,String word2,int hi1,int hi2) {
    	
    	
    	if(word1.charAt(hi1)==word2.charAt(hi2)) {
    		return dfs(word1,word2,hi1-1,hi2-1);
    	}else {
    		return Math.min(Math.min(dfs(word1,word2,hi1-1,hi2-1),
    				dfs(word1,word2,hi1-1,hi2)), 
    				dfs(word1,word2,hi1,hi2-1))+1;
    	}
    }
}
